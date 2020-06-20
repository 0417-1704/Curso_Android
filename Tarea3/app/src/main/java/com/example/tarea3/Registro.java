package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText et_nombre,et_email, et_telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        et_nombre = (EditText)findViewById(R.id.tv2pres);
        et_email= (EditText)findViewById(R.id.tv3pres);
        et_telefono = (EditText)findViewById(R.id.tv4pres);
    }
    public void volver(View v2){
        Intent i2 = new Intent(this, PantallaOpciones.class);
        startActivity(i2);
    }
    public void inicio(View v2){
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2);
    }

    //Método para registrar un usuario
    public void registrar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        //Abrimos en modo lectura
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String nombre = et_nombre.getText().toString();
        String email = et_email.getText().toString();
        String telefono = et_telefono.getText().toString();

        if(!telefono.isEmpty() && !nombre.isEmpty() && !email.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("telefono", telefono);
            registro.put("nombre", nombre);
            registro.put("email", email);


            BaseDeDatos.insert("cliente", null, registro);
            BaseDeDatos.close();

            et_telefono.setText("");
            et_nombre.setText("");
            et_email.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    //Método para buscar un usuario
    public void buscar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String telefono = et_telefono.getText().toString();
        if(!telefono.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select nombre,email from cliente where nombre = "+telefono, null);

            if(fila.moveToFirst()){
                et_nombre.setText(fila.getString(0));
                et_email.setText(fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this,"El usuario no existe", Toast.LENGTH_LONG).show();
                BaseDeDatos.close();
            }

        }else{
            Toast.makeText(this,"Debes introducir el telefono de usuario", Toast.LENGTH_LONG).show();
        }
    }

    //Método para el boton eliminar
    public void eliminar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String telefono = et_telefono.getText().toString();
        if(!telefono.isEmpty()){
            int cantidad = BaseDeDatos.delete( "cliente", "telefono ="+telefono, null);
            BaseDeDatos.close();
            et_telefono.setText("");
            et_nombre.setText("");
            et_email.setText("");

            if(cantidad == 1){
                Toast.makeText(this,"Usuario eliminado exitosamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"El usuario no existe", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Debes introducir el telefono del usuario", Toast.LENGTH_LONG).show();
            BaseDeDatos.close();
        }
    }
    //Método para el botón de modificar
    public void modificar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String telefono = et_telefono.getText().toString();
        String nombre = et_nombre.getText().toString();
        String email = et_email.getText().toString();


        if(!telefono.isEmpty() && !nombre.isEmpty() && !email.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("telefono", telefono);
            registro.put("nombre", nombre);
            registro.put("email", email);


            int cantidad = BaseDeDatos.update( "cliente", registro, "telefono= "+telefono, null);
            BaseDeDatos.close();

            if(cantidad == 1){
                Toast.makeText(this,"Usuario modificado exitosamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"El usuario no existe", Toast.LENGTH_LONG).show();
            }
            //
        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
    /**
    public void resultado(View v){
        Intent i = new Intent(this, Resultado.class);

        i.putExtra("nombre", edt1.getText().toString());
        i.putExtra("e-mail", edt2.getText().toString());
        i.putExtra("telefono", edt3.getText().toString());

        startActivity(i);
    }
     */
}
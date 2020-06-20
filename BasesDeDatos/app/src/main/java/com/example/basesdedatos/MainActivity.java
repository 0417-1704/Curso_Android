package com.example.basesdedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText et_codigo,et_descripcion, et_precio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_codigo = (EditText)findViewById(R.id.ed1);
        et_descripcion = (EditText)findViewById(R.id.ed2);
        et_precio = (EditText)findViewById(R.id.ed3);

    }

    //Método para el boton registrar
    public void registrar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        //Abrimos en modo lectura
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            BaseDeDatos.insert("articulos", null, registro);
            BaseDeDatos.close();

            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");
            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }

    //Metodo para el metodo buscar
    public void buscar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select descripcion,precio from articulos where codigo = "+codigo, null);

            if(fila.moveToFirst()){
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this,"El articulo no existe", Toast.LENGTH_LONG).show();
                BaseDeDatos.close();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo", Toast.LENGTH_LONG).show();
        }
    }

    //Método para el boton eliminar
    public void eliminar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        if(!codigo.isEmpty()){
            int cantidad = BaseDeDatos.delete( "articulos", "codigo ="+codigo, null);
            BaseDeDatos.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");
            if(cantidad == 1){
                Toast.makeText(this,"Articulo eliminado exitosamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"El articulo no existe", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo", Toast.LENGTH_LONG).show();
            BaseDeDatos.close();
        }
    }

    //Metodo para el boton de modificar
    public void modificar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = BaseDeDatos.update( "articulos", registro, "codigo= "+codigo, null);
            BaseDeDatos.close();

            if(cantidad == 1){
                Toast.makeText(this,"Artículo modificado exitosamente", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"El articulo no existe", Toast.LENGTH_LONG).show();
            }
            //
        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}
package com.example.almacenamientodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_nombre;
    EditText ed_email;
    EditText ed_telefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_nombre = (EditText)findViewById(R.id.ed1);
        ed_email = (EditText)findViewById(R.id.ed2);
        //Teléfono permite varias líneas de código
        ed_telefono = (EditText)findViewById(R.id.ed3);


        //Resupera lo guardado en sharedPreferences
        //SharedPreferences sp = getSharedPreferences("datos", Context.MODE_PRIVATE);

        //        Las comillas de defValue evita errores
        //ed1.setText(sp.getString("mail", ""));
    }

    //Método para el boton guardar
    public void guardar(View v){
        String nombre = ed_nombre.getText().toString();
        String mail = ed_email.getText().toString();
        String telefono = ed_telefono.getText().toString();
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor  se = sp.edit();
        se.putString(nombre, telefono);
        se.putString(nombre, mail);
        //se.putString("n", ed_nombre.getText().toString());
        se.commit();

        //finish();
        Toast.makeText(this,"El concacto ha sido guardado", Toast.LENGTH_LONG).show();
    }

    //Método para el botón buscar
    public void buscar(View v){
        String nombre = ed_nombre.getText().toString();
        String mail = ed_email.getText().toString();
        String telefono = ed_telefono.getText().toString();

        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos1 = sp.getString(nombre, mail);
        String datos2 = sp.getString(nombre, telefono);

        if(datos1.length()==0 && datos2.length()==0){
            Toast.makeText(this,"Contacto no encontrado", Toast.LENGTH_LONG).show();
        }else{
            ed_telefono.setText(datos1);
            ed_email.setText(datos2);
        }

    }
}
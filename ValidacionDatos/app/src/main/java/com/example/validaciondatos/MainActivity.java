package com.example.validaciondatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtnom, edtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnom = (EditText)findViewById(R.id.txt_nombre);
        edtpass = (EditText)findViewById(R.id.txt_pswd);
    }

    //Método para el botón
    public void Registra(View v){
        String nombre = edtnom.getText().toString();
        String password = edtpass.getText().toString();

        if(nombre.length()==0){
            Toast.makeText(this, "Ingresa un nombre válido", Toast.LENGTH_LONG).show();
        }
        if(password.length()==0){
            Toast.makeText(this, "Ingresa un password verdadero", Toast.LENGTH_SHORT).show();
        }
        if(nombre.length() != 0 &&  password.length() != 0){
            Toast.makeText(this, "Registro en proceso", Toast.LENGTH_SHORT).show();
        }
    }
}
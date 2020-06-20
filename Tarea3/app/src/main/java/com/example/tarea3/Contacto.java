package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Contacto extends AppCompatActivity {
    EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        edt1 = (EditText)findViewById(R.id.ed_enviar);
    }

    public void inicio(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void regresa(View v){
        Intent i = new Intent(this, PantallaOpciones.class);
        startActivity(i);
    }
    public void enviar(View v){
        Intent i = new Intent(this, Resultado.class);

        i.putExtra("cadena", edt1.getText().toString());

        startActivity(i);
    }
}
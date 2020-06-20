package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        tv1 = (TextView)findViewById(R.id.txt_mensaje);

        String cadena = getIntent().getStringExtra("cadena");

        tv1.setText("Enviaste el mensaje:  "+cadena);
    }

    public void volver(View v2){
        Intent i2 = new Intent(this, Contacto.class);
        startActivity(i2);
    }
    /**
    public void inicio(View v2){
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2);
    }
     */

}
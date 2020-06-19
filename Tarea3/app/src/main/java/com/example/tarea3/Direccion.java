package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Direccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion);
    }
    public void inicio(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void regresa(View v){
        Intent i = new Intent(this, PantallaOpciones.class);
        startActivity(i);
    }
}
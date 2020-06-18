package com.example.cambiodeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SegundaPantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
    }
    //Método para el botón anterior
    public void anterior(View v2){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}
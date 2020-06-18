package com.example.cambiodeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método de botón siguiente
    public void siguiente(View v){
        Intent siguiente = new Intent(this, SegundaPantalla.class);
        startActivity(siguiente);
    }

}
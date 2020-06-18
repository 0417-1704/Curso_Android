package com.example.compartirvaloresactivitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaPantalla extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        tv1 = (TextView)findViewById(R.id.tv3);

        String cadena = getIntent().getStringExtra("cadena");

        tv1.setText("Hola "+cadena);
    }

    public void volver(View v2){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
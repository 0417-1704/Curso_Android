package com.example.imagebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void instrumentoMeansaje(View v){
        Toast.makeText(this,"Genial, si sabes que es un instrumento musical", Toast.LENGTH_LONG).show();
    }

    public void mayonesaMeansaje(View v){
        Toast.makeText(this,"No Patricio, la mayonesa no es un instrumento", Toast.LENGTH_LONG).show();
    }
}
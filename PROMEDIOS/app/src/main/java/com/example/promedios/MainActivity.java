package com.example.promedios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText)findViewById(R.id.fisica);
        edt2 = (EditText)findViewById(R.id.mate);
        edt3 = (EditText)findViewById(R.id.quimica);
        tv = (TextView)findViewById(R.id.tv);
    }

    public void promedio(View v){
        String val1 = edt1.getText().toString();
        String val2 = edt2.getText().toString();
        String val3 = edt3.getText().toString();

        int valor1 = Integer.parseInt(val1);
        int valor2 = Integer.parseInt(val2);
        int valor3 = Integer.parseInt(val3);

        double prom = (valor1 + valor2 + valor3)/3;


        if(prom >= 6){
            tv.setText("Te mamaste, aprobaste con: "+prom);
        }else if(prom <= 5){
            tv.setText("Tas bien pendejo, reprobaste con: "+prom+ " :v");
        }
    }
}
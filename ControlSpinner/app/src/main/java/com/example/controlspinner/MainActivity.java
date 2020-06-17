package com.example.controlspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner s1;
    private EditText edt1;
    private EditText edt2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText)findViewById(R.id.ed1);
        edt2 = (EditText)findViewById(R.id.ed2);

        tv1 = (TextView)findViewById(R.id.tv2);

        s1 = (Spinner)findViewById(R.id.spinner);

        String [] opciones = {"SUMAR", "RESTAR", "MULTIPLICAR", "DIVIDIR", "EXPONENTE"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        s1.setAdapter(adapter);
    }

    //Método que relaiza los calculos del botón
    public void calcular(View v){
        String sv1 = edt1.getText().toString();
        String sv2= edt2.getText().toString();

        int iv1 = Integer.parseInt(sv1);
        int iv2 = Integer.parseInt(sv2);

        String seleccion = s1.getSelectedItem().toString();

        if(seleccion.equals("SUMAR")){
            int suma = iv1+iv2;
            String res = String.valueOf(suma);
            tv1.setText(res);
        }else if(seleccion.equals("RESTAR")){
            int resta = iv1-iv2;
            String  res = String.valueOf(resta);
            tv1.setText(res);
        }else if(seleccion.equals("MULTIPLICAR")){
            int multi = iv1*iv2;
            String  res = String.valueOf(multi);
            tv1.setText(res);
        }else if(seleccion.equals("DIVIDIR")){
                if(iv2 != 0){
                    double divi = iv1/iv2;
                    String  res = String.valueOf(divi);
                    tv1.setText(res);
                }else{
                    Toast.makeText(this,"No se puede dividir entre 0", Toast.LENGTH_LONG).show();
                }

        }else if(seleccion.equals("EXPONENTE")){
            double power = Math.pow(iv1,iv2);
            String  res = String.valueOf(power);
            tv1.setText(res);
        }

    }
}
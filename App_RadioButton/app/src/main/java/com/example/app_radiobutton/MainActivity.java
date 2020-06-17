package com.example.app_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv2;
    private EditText et1;
    private EditText et2;
    private RadioButton rb1, rb2, rb3, rb4, rb5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.ed1);
        et2 = (EditText)findViewById(R.id.ed2);
        tv2 = (TextView)findViewById(R.id.txtv2);

        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        rb4 = (RadioButton)findViewById(R.id.rb4);
        rb5 = (RadioButton)findViewById(R.id.rb5);

    }

    //Método para el boton calcular
    public void calcular(View v){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int int1 = Integer.parseInt(valor1);
        int int2 = Integer.parseInt(valor2);
        if(rb1.isChecked()==true){
            int suma = int1 + int2;
            String res = String.valueOf(suma);
            tv2.setText(res);
        }else if(rb2.isChecked()==true){
            int multi = int1 * int2;
            String res = String.valueOf(multi);
            tv2.setText(res);
        }else if(rb3.isChecked()==true){
            int resta = int1 - int2;
            String res = String.valueOf(resta);
            tv2.setText(res);
        }else if(rb4.isChecked()==true){

                if(int2 == 0){
                    Toast.makeText(this, "No seas pndj*, no puedes dividir entre 0", Toast.LENGTH_SHORT).show();
                }else{
                    double divi = int1 / int2;
                    String res = String.valueOf(divi);
                    tv2.setText(res);
                }
        } else if(rb5.isChecked()==true){
                if(int2 == 0){
                    tv2.setText("1");
                }else{
                    double exp = Math.pow(int1, int2);
                    String res = String.valueOf(exp);
                    tv2.setText(res);
                }
        }
    }

}
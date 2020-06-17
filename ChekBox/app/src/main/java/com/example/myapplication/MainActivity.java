package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edt1;
    private EditText edt2;
    private TextView tv2;
    private CheckBox cbx1, cbx2, cbx3,cbx4,cbx5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText)findViewById(R.id.ed1);
        edt2 = (EditText)findViewById(R.id.ed2);

        cbx1 = (CheckBox)findViewById(R.id.cb1);
        cbx2 = (CheckBox)findViewById(R.id.cb2);
        cbx3 = (CheckBox)findViewById(R.id.cb3);
        cbx4 = (CheckBox)findViewById(R.id.cb4);
        cbx5 = (CheckBox)findViewById(R.id.cb5);

        tv2 = (TextView)findViewById(R.id.tv2);
    }

    //Método para el botón calcular
    public void calcular(View v){
        String sv1 = edt1.getText().toString();
        String sv2 = edt2.getText().toString();

        int iv1 = Integer.parseInt(sv1);
        int iv2 = Integer.parseInt(sv2);

        String res= "";

        if(cbx1.isChecked()==true){
            int suma = iv1 + iv2;
            res = "La suma es: "+suma +"/";
        }
        if(cbx2.isChecked()==true){
            int resta = iv1 - iv2;
            res = res + "La resta es: "+ resta;
        }
        if(cbx3.isChecked()==true){
            int multi = iv1 * iv2;
            res = res + "La multipliacion es: "+multi;
        }if(cbx4.isChecked()==true){
            int divi = iv1/iv2;
            res = res + "La división es: "+ divi;
        }if(cbx5.isChecked()==true){
            double power = Math.pow(iv1, iv2);
            res = res + "Elevar "+iv1+" a la potencia "+iv2+" es: "+power;
        }
        tv2.setText(res);
    }
}
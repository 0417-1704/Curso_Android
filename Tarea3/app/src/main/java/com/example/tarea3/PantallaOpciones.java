package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PantallaOpciones extends AppCompatActivity {
    private TextView tv1;
    private ListView lv1;
    private String [] opciones= {"Contacto","Acerca de","Dirección", "Catálogo", "Registrar como cliente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_opciones);

        //tv1 = (TextView)findViewById(R.id.tv2po);
        lv1 = (ListView)findViewById(R.id.lvpo);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_pantalla_opciones, opciones);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                if(i==0){
                    Intent i3 = new Intent(PantallaOpciones.this, Contacto.class);
                    startActivity(i3);
                }else if(i==1){
                    Intent i5 = new Intent(PantallaOpciones.this, AcercaDe.class);
                    startActivity(i5);
                }else if(i==2){
                    Intent i4 = new Intent(PantallaOpciones.this, Direccion.class);
                    startActivity(i4);
                }else if(i==3){
                    Intent i6 = new Intent(PantallaOpciones.this, Catalogo.class);
                    startActivity(i6);
                }else if(i==4){
                    Intent i7 = new Intent(PantallaOpciones.this, Registro.class);
                    startActivity(i7);
                }
             }
        });
    }



    public void volver(View v2){
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2);
    }

}
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
    private String [] nombres= {"Contacto","Acerda de","Dirección", "Catálogo", "Registrar como cliente"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_opciones);

        tv1 = (TextView)findViewById(R.id.tv2po);
        lv1 = (ListView)findViewById(R.id.lvpo);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_pantalla_opciones, nombres);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                tv1.setText("Seleccionaste: "+lv1.getItemIdAtPosition(i)+nombres[i]);
            }
        });
    }
    public void volver(View v2){
        Intent i2 = new Intent(this, MainActivity.class);
        startActivity(i2);
    }
    public void siguiente(View v2){
        Intent i2 = new Intent(this, AcercaDe.class);
        startActivity(i2);
    }
}
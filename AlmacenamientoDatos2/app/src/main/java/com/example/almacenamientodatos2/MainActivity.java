package com.example.almacenamientodatos2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.edml);

        String archivos[] = fileList();

        if(ArchivoExiste(archivos, "bitacora.txt")){
            try{
                InputStreamReader archivo= new InputStreamReader(openFileInput("bitacora.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String bitacoraCompleta = "";

                while(linea != null){
                    bitacoraCompleta = bitacoraCompleta + linea+ "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                ed1.setText(bitacoraCompleta);
            }catch (IOException e){

            }
        }
    }

    private boolean ArchivoExiste(String archivos[], String NombreArchivo){
        for(int i = 0;i<archivos.length;i++)
            if(NombreArchivo.equals(archivos[i]))
                return true;
            return false;
    }

    //Metodo para el botón guardar
    public void guardar(View v){
        try {
                OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacota.txt", Activity.MODE_PRIVATE));
                archivo.write(ed1.getText().toString());
                archivo.flush();
        }catch (IOException e){

            }
        Toast.makeText(this,"Bitacora guardada correctamente", Toast.LENGTH_LONG).show();
        }
}
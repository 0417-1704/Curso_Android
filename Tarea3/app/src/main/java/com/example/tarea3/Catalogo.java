package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ahmed.easyslider.EasySlider;
import ahmed.easyslider.SliderItem;

public class Catalogo extends AppCompatActivity {
    EasySlider es;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        es = (EasySlider)findViewById(R.id.slider);
        List<SliderItem> lista = new ArrayList<>();

        lista.add(new SliderItem("Dental",R.drawable.doctor));
        lista.add(new SliderItem("Doctor",R.drawable.dental));
        lista.add(new SliderItem("Hand",R.drawable.mano));
        lista.add(new SliderItem("Hospital",R.drawable.hospital));

        es.setPages(lista);
    }
}
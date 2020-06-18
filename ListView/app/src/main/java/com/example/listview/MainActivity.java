package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private ListView lv1;
    private String [] nombres= {"Samuel","Valentina","Santiago","Alejandro","Valeria","Benjamín","Gerardo","Carlos", "David", "Sofia"};
    private String [] edades = {"18","25","15","24","20","35","27","19","22","12","26"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);
        lv1 = (ListView)findViewById(R.id.lv1);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_diego, nombres);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                tv1.setText("La edad de "+lv1.getItemIdAtPosition(i)+" es "+edades[i]+" años");
            }
        });
    }
}
//tv1.setText("La edad de "+lv1.getItemIdAtPosition(position)+" es"+edades[position]+" años");
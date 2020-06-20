package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SitioWeb extends AppCompatActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitio_web);

        wv = (WebView)findViewById(R.id.wv1);

        String url = getIntent().getStringExtra("web");

        wv.setWebViewClient(new WebViewClient());

        wv.loadUrl("http://"+url);
    }

    public void regresar (View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
package com.example.supaj.beginnercontent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webview = new WebView(this);
        setContentView(webview);

        webview.loadUrl("https://developer.android.com/");
    }

}

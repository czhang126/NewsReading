package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class Map extends AppCompatActivity {

    // News Element: webView
    WebView webView;

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_map);

        // WebView creation and configuration
        webView = (WebView)findViewById(R.id.webMap);
        webView.loadUrl("file:///android_asset/simplemap.html");
        webView.getSettings().setJavaScriptEnabled(true);
    }
}

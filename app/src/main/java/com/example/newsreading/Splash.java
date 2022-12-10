package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Chen Zhang
 * Date : 2022-12-05
 */

import android.os.Looper;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    // Splash Element: sHandler
    private final Handler sHandler = new Handler(Looper.myLooper());

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_splash);

        // Search Bar creation and configuration
        ActionBar ssBar = getSupportActionBar();
        if (ssBar != null) {
            ssBar.hide();
        }

        // Delay and jump page
        sHandler.postDelayed(() -> {
            Class act = Login.class;
            if (null != App.nowUser) {
                act = NewsList.class;
            }
            Intent isa = new Intent(getApplicationContext(), act);
            startActivity(isa);
            Splash.this.finish();
        }, 3000);
    }
}
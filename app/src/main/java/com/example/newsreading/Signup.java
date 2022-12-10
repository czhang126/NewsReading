package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_signup);

        // Search Bar creation and configuration
        ActionBar ssBar = getSupportActionBar();
        if (ssBar != null) {
            ssBar.hide();
        }

        // Signup page details creation and configuration
        EditText etsUsername = findViewById(R.id.editTextSignupUsername);
        EditText etsPassword = findViewById(R.id.editTextSignupPassword);
        EditText etsPasswordAgain = findViewById(R.id.editTextSignupPasswordAgain);
        Button bSignup = findViewById(R.id.buttonSignup);
        bSignup.setOnClickListener(view -> {
            String un = etsUsername.getText().toString().trim();
            String pw = etsPassword.getText().toString().trim();
            String pwa = etsPasswordAgain.getText().toString().trim();
            executeSignup(un, pw, pwa);
        });
        Button bBackToLogin = findViewById(R.id.buttonBackToLogin);
        bBackToLogin.setOnClickListener(view -> {
            Signup.this.finish();
        });
    }

    // executeSignup
    private void executeSignup(String sun, String spw, String spwa) {
        if (sun.length() == 0) {
            Toast.makeText(getApplicationContext(), "Username cannot be empty. Please enter Username!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (spw.length() == 0) {
            Toast.makeText(getApplicationContext(), "Password cannot be empty. Please enter Password!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!spw.equals(spwa)) {
            Toast.makeText(getApplicationContext(), "Two passwords are different. Please check them!", Toast.LENGTH_SHORT).show();
            return;
        }
        DatabaseHelper dh = DatabaseHelper.getDh();
        dh.signup(sun, spw);
        Toast.makeText(getApplicationContext(), "Signup success!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Please login!", Toast.LENGTH_LONG).show();
        Signup.this.finish();
    }
}

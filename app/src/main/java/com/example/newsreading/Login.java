package com.example.newsreading;
/**
 * Final Project - ITMD555
 * Programmer : Zhaohua Pang
 * Date : 2022-12-05
 */

import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_login);

        // Search Bar creation and configuration
        ActionBar lsBar = getSupportActionBar();
        if (lsBar != null) {
            lsBar.hide();
        }

        // Login page details creation and configuration
        EditText etlUsername = findViewById(R.id.editTextLoginUsername);
        EditText etlPassword = findViewById(R.id.editTextLoginPassword);
        Button bLogin = findViewById(R.id.buttonLogin);
        bLogin.setOnClickListener(view -> {
            String un = etlUsername.getText().toString().trim();
            String pw = etlPassword.getText().toString().trim();
            executeLogin(un, pw);
        });
        Button bGoToSignup = findViewById(R.id.buttonGoToSignup);
        bGoToSignup.setOnClickListener(view -> {
            Intent ils = new Intent(getApplicationContext(), Signup.class);
            startActivity(ils);
        });
        Button bGoogleMap = findViewById(R.id.buttonGoogleMap);
        bGoogleMap.setOnClickListener(view -> {
            Intent ilm = new Intent(getApplicationContext(), Map.class);
            startActivity(ilm);
        });
    }

    // executeLogin
    private void executeLogin(String lun, String lpw) {
        if (lun.length() == 0) {
            Toast.makeText(getApplicationContext(), "Username cannot be empty. Please enter Username!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (lpw.length() == 0) {
            Toast.makeText(getApplicationContext(), "Password cannot be empty. Please enter Password!", Toast.LENGTH_SHORT).show();
            return;
        }
        DatabaseHelper dh = DatabaseHelper.getDh();
        UserModel lUser = dh.getUser(lun);
        if (null == lUser) {
            Toast.makeText(getApplicationContext(), "Username does not exist!", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean lSuccess = dh.login(lun, lpw);
        if (lSuccess) {
            Login.this.finish();
            String lTopic = lUser.getUserTopic();
            App.nowUser = lUser;
            Class act = NewsList.class;
            if (null == lTopic || lTopic.length() == 0) {
                act = ChooseTopic.class;
            } else {
                Toast.makeText(getApplicationContext(), "Welcome " + lun + "!", Toast.LENGTH_SHORT).show();
            }
            Intent ila = new Intent(getApplicationContext(), act);
            startActivity(ila);
        } else {
            Toast.makeText(getApplicationContext(), "Password is wrong. Please re-enter your password!", Toast.LENGTH_SHORT).show();
        }
    }
}
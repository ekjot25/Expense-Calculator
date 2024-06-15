package com.astirmind.expense_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {


    private static final String PREFS_NAME = "MyLoginPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        SharedPreferences sh = getSharedPreferences("Log", MODE_PRIVATE);
        String hasLoggedIn = sh.getString("email", "");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(hasLoggedIn.equals(""))
                {

                        Intent intent = new Intent(SplashActivity.this,MainActivity2.class);
                        startActivity(intent);
                        finish();



                }
                else
                {
                    Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                finish();

            }
        }, 3000);
    }
}
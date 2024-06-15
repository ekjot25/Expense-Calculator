package com.astirmind.expense_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ImageView bckimg = (ImageView) findViewById(R.id.bck);
        TextView logout = (TextView) findViewById(R.id.logout);
        TextView account = (TextView) findViewById(R.id.account);
        TextView currncy = (TextView) findViewById(R.id.currncy);
        TextView security = (TextView) findViewById(R.id.security);
        TextView remind = (TextView) findViewById(R.id.remind);


        ImageView bck = (ImageView)findViewById(R.id.bck);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bckimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fn = new Intent(SettingActivity.this, Security.class);
//                finish();
                startActivity(fn);

            }
        });

        remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fn = new Intent(SettingActivity.this, RemindActivity.class);
//                finish();
                startActivity(fn);

            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fn = new Intent(SettingActivity.this, Account_info.class);
//                finish();
                startActivity(fn);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sh = getSharedPreferences("Log", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sh.edit();
                myEdit.clear();
                myEdit.commit();

                Intent fn = new Intent(SettingActivity.this, SplashActivity.class);
                finish();
                startActivity(fn);
            }
        });

        currncy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fn = new Intent(SettingActivity.this, CurrencyActivity.class);
                finish();
                startActivity(fn);
            }
        });
    }
}
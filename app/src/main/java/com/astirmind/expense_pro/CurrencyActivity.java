package com.astirmind.expense_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_currency);
        TextView dollar = (TextView) findViewById(R.id.dollar);
        TextView yen = (TextView) findViewById(R.id.yen);
        TextView rupee = (TextView) findViewById(R.id.rupee);
        TextView euro = (TextView) findViewById(R.id.euro);
        TextView cdollar = (TextView) findViewById(R.id.cdollar);
        TextView pound = (TextView) findViewById(R.id.pound);


        SharedPreferences sh = getSharedPreferences("Log", MODE_PRIVATE);
        String curr = sh.getString("curr", "");

        ImageView bck = (ImageView)findViewById(R.id.bck);
        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (!curr.equals(""))
        {
            if(curr.equals("dollar")) {
                dollar.setTextColor(Color.GRAY);
            }
            else if(curr.equals("yen")){
            yen.setTextColor(Color.GRAY);}

            else if(curr.equals("rupee")){
                rupee.setTextColor(Color.GRAY);}

            else if(curr.equals("euro")){
                euro.setTextColor(Color.GRAY);}

            else if(curr.equals("cdollar")){
                cdollar.setTextColor(Color.GRAY);}

            else if(curr.equals("pound")){
                pound.setTextColor(Color.GRAY);}

        }
        else {
            dollar.setTextColor(Color.GRAY);
            yen.setTextColor(Color.WHITE);
            rupee.setTextColor(Color.WHITE);
            euro.setTextColor(Color.WHITE);
            cdollar.setTextColor(Color.WHITE);
            pound.setTextColor(Color.WHITE);

            SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();

            myEdit.putString("curr", "dollar");

            myEdit.commit();

        }

        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dollar.setTextColor(Color.GRAY);
                yen.setTextColor(Color.WHITE);
                rupee.setTextColor(Color.WHITE);
                euro.setTextColor(Color.WHITE);
                cdollar.setTextColor(Color.WHITE);
                pound.setTextColor(Color.WHITE);

                SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("curr", "dollar");

                myEdit.commit();

            }
        });


        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dollar.setTextColor(Color.WHITE);
                yen.setTextColor(Color.GRAY);
                rupee.setTextColor(Color.WHITE);
                euro.setTextColor(Color.WHITE);
                cdollar.setTextColor(Color.WHITE);
                pound.setTextColor(Color.WHITE);

                SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("curr", "yen");

                myEdit.commit();

            }
        });


        rupee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dollar.setTextColor(Color.WHITE);
                yen.setTextColor(Color.WHITE);
                rupee.setTextColor(Color.GRAY);
                euro.setTextColor(Color.WHITE);
                cdollar.setTextColor(Color.WHITE);
                pound.setTextColor(Color.WHITE);

                SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("curr", "rupee");

                myEdit.commit();

            }
        });

        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dollar.setTextColor(Color.WHITE);
                yen.setTextColor(Color.WHITE);
                rupee.setTextColor(Color.WHITE);
                euro.setTextColor(Color.GRAY);
                cdollar.setTextColor(Color.WHITE);
                pound.setTextColor(Color.WHITE);

                SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("curr", "euro");

                myEdit.commit();

            }
        });


        cdollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dollar.setTextColor(Color.WHITE);
                yen.setTextColor(Color.WHITE);
                rupee.setTextColor(Color.WHITE);
                euro.setTextColor(Color.WHITE);
                cdollar.setTextColor(Color.GRAY);
                pound.setTextColor(Color.WHITE);

                SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("curr", "cdollar");

                myEdit.commit();

            }
        });


        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dollar.setTextColor(Color.WHITE);
                yen.setTextColor(Color.WHITE);
                rupee.setTextColor(Color.WHITE);
                euro.setTextColor(Color.WHITE);
                cdollar.setTextColor(Color.WHITE);
                pound.setTextColor(Color.GRAY);

                SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                myEdit.putString("curr", "pound");

                myEdit.commit();

            }
        });
    }
}
package com.astirmind.expense_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Account_info extends AppCompatActivity {
    EditText username,email,c_paswd,nc_paswd,rnc_paswd;
    TextView register,p_name;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        c_paswd = (EditText) findViewById(R.id.c_paswd);
        nc_paswd = (EditText) findViewById(R.id.nc_paswd);
        rnc_paswd = (EditText) findViewById(R.id.rnc_paswd);
        register = (TextView) findViewById(R.id.register);
        p_name = (TextView) findViewById(R.id.p_name);
        dbHandler = new DBHandler(getApplicationContext());

        SharedPreferences sh = getSharedPreferences("Log", MODE_PRIVATE);
        String id = sh.getString("id", "");

        List<String> st = dbHandler.getUser(id);

        username.setText(st.get(2));
        p_name.setText(st.get(2));
        email.setText(st.get(3));
        c_paswd.setText(st.get(4));



    }
}
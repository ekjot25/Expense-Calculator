package com.astirmind.expense_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText email,passd;
    TextView login,regster;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email = (EditText) findViewById(R.id.email);
        passd = (EditText) findViewById(R.id.passd);
        login = (TextView) findViewById(R.id.login);
        regster = (TextView) findViewById(R.id.regster);

        regster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intent = new Intent(MainActivity2.this,RegisterActivity.class);
                        startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("") && passd.getText().toString().equals("") )
                {
                    Toast.makeText(getApplicationContext(),"All the feild are required",Toast.LENGTH_LONG).show();
                }
                else {
                    dbHandler = new DBHandler(getApplicationContext());

                    String st = dbHandler.checkUser(email.getText().toString(), passd.getText().toString());
                    if(!st.equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Login Succesfully",Toast.LENGTH_LONG).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("Log",MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = sharedPreferences.edit();
                        myEdit.putString("email", email.getText().toString());
                        myEdit.putString("passd", passd.getText().toString());
                        myEdit.putString("id", st.toString());

                        myEdit.commit();


                        Intent intent = new Intent(MainActivity2.this,HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Authentication Failed",Toast.LENGTH_LONG).show();
                    }




                }
            }
        });

    }
}
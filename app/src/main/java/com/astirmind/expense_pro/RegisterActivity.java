package com.astirmind.expense_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,name,email,passd,cnpassd;
    TextView register;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.username);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        passd = (EditText) findViewById(R.id.passd);
        cnpassd = (EditText) findViewById(R.id.cnpassd);
        register = (TextView) findViewById(R.id.register);
        dbHandler = new DBHandler(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("") && name.getText().toString().equals("") && email.getText().toString().equals("") && passd.getText().toString().equals("") && cnpassd.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"All the feild are required",Toast.LENGTH_LONG).show();
                }
                else {
//                    ---------------------------------------------------
                    if(passd.getText().toString().equals( cnpassd.getText().toString())) {
                        String username_ = username.getText().toString();
                        String name_ = name.getText().toString();
                        String email_ = email.getText().toString();

                        String passd_ = passd.getText().toString();
                        ;
//                        String curr = register.getText().toString();
                        ;

//                    // validating if the text fields are empty or not.
//                    if (budget_nam.isEmpty() && budget_amoun.isEmpty() && budget_Dae.isEmpty() && reccuranc.isEmpty() && curr.isEmpty()) {
//                        Toast.makeText(getActivity().getApplicationContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
//                        return;
//                    }

                        // on below line we are calling a method to add new
                        // course to sqlite data and pass all our values to it.
                        dbHandler.addUser(username_, name_, email_, passd_);
//                tring budgetname, String budgetamount, String budgetcurr,String budgetstart_date, String budgetreccurence
                        // after adding the data we are displaying a toast message.
                        Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();


//                    ---------------------------------------------------


                        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password Mismatched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
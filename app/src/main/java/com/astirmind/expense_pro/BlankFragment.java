package com.astirmind.expense_pro;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BlankFragment extends Fragment  implements
        AdapterView.OnItemSelectedListener {
    String[] reccurance = { "Monthly", "weekly", "Daily"};
    String[] currancy = { "(₹) Rupee", "($) dollar", "(€) euro", "(£) pound","(¥) yen", " ($) Canadian Dollar", "(£) pound"};
    TextView budget_Date, budget_mnth ,create_budget;
    EditText budget_name,budget_amount;
    final Calendar myCalendar= Calendar.getInstance();
    private DBHandler dbHandler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        dbHandler = new DBHandler(getActivity());
        DateFormat dateFormat = new SimpleDateFormat("MMM yyyy");
        Date ddate = new Date();

        String dd = dateFormat.format(ddate);

         budget_mnth = (TextView) view.findViewById(R.id.budget_mnth);
         budget_Date = (TextView) view.findViewById(R.id.budget_Date);
         create_budget = (TextView) view.findViewById(R.id.create_budget);
         budget_name = (EditText) view.findViewById(R.id.budget_name);
         budget_amount = (EditText) view.findViewById(R.id.budget_amount);

        Spinner spin = (Spinner) view.findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the reccurance list
        ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,reccurance);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);



        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);

        ArrayAdapter aa1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,currancy);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner1.setAdapter(aa1);

        budget_mnth.setText(String.valueOf(dd));



        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                budget_Date.setText(dayOfMonth+"/"+monthOfYear +"/"+year);
            }

        };


        budget_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog=  new DatePickerDialog(getActivity(),R.style.DialogTheme, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });


//        spinner1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        create_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String budget_nam = budget_name.getText().toString();
                String budget_amoun = budget_amount.getText().toString();
                String budget_Dae = budget_Date.getText().toString();;
                String reccuranc = spin.getSelectedItem().toString();
                String curr = spinner1.getSelectedItem().toString();

                // validating if the text fields are empty or not.
                if (budget_nam.isEmpty() && budget_amoun.isEmpty() && budget_Dae.isEmpty() && reccuranc.isEmpty() && curr.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(budget_nam, budget_amoun, curr , budget_Dae, reccuranc);
//                tring budgetname, String budgetamount, String budgetcurr,String budgetstart_date, String budgetreccurence
                // after adding the data we are displaying a toast message.
                Toast.makeText(getActivity(), "Budget has been added.", Toast.LENGTH_SHORT).show();

                budget_name.setText("");
               budget_amount.setText("");
                budget_Date.setText("");;
               spin.setSelection(0);
              spinner1.setSelection(0);


//                HomeActivity homeActivity= new HomeActivity();
//                homeActivity.loadFragment(new HomeFragment());

            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
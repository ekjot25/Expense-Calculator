package com.astirmind.expense_pro;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HomeFragment extends Fragment {
    private ArrayList<CourseModal> courseModalArrayList;
    private DBHandler dbHandler;
    public static CourseRVAdapter courseRVAdapter;
    public static RecyclerView coursesRV;
    public static TextView sddate,prcnt,spent__;
    public static ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        dbHandler = new DBHandler(getActivity());

        courseModalArrayList = dbHandler.readCourses();
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        courseRVAdapter = new CourseRVAdapter(courseModalArrayList, getActivity().getApplicationContext());
        coursesRV = view.findViewById(R.id.recyclerview);
        sddate = view.findViewById(R.id.date);
        prcnt = view.findViewById(R.id.prcnt);
        spent__ = view.findViewById(R.id.spent__);

        DateFormat dateFormat = new SimpleDateFormat("MMM yyyy");
        Date ddate = new Date();

        String dd = dateFormat.format(ddate);

        sddate.setText(dd);
        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);
        return view;
    }


}
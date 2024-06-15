package com.astirmind.expense_pro;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<CourseModal> courseModalArrayList;
     Context context;
    private DBHandler dbHandler;
    int total_,spent_;
    // constructor
    public CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        CourseModal modal = courseModalArrayList.get(position);
        holder.budget_title.setText(modal.getBudget_name());

        int spnt = Integer.parseInt(modal.getBudget_spent());
        int bdgt = Integer.parseInt(modal.getBudget_amount());
        spent_=  spent_ + spnt;
        total_=  total_ + bdgt;

        float spent__per = Float.valueOf(spent_) / Float.valueOf(total_) *100;

        HomeFragment.progressBar.setProgress(Math.round(spent__per));
        HomeFragment.prcnt.setText(String.valueOf(Math.round(spent__per))+" %");
        HomeFragment.spent__.setText("$ "+String.valueOf(Math.round(spent_))+" Spent");



        int balance = bdgt - spnt;
        float balance_per = Float.valueOf(spnt) / Float.valueOf(bdgt) *100;

        holder.budget.setText(String.valueOf(balance)+"/"+modal.getBudget_amount());
        holder.progressBar.setProgress(Math.round(balance_per));



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialogClass cdd=new CustomDialogClass(v.getRootView().getContext(),modal.getBudget_id(),spnt);
                cdd.show();

            }
        });

//        holder.courseDurationTV.setText(modal.getCourseDuration());
//        holder.courseTracksTV.setText(modal.getCourseTracks());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView budget_title, budget, courseDurationTV, courseTracksTV;
        ProgressBar progressBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            budget_title = itemView.findViewById(R.id.budget_title);
            budget = itemView.findViewById(R.id.budget);
            progressBar = itemView.findViewById(R.id.progressBar);

//            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
//            courseTracksTV = itemView.findViewById(R.id.idTVCourseTracks);
        }
    }

    public class CustomDialogClass extends Dialog implements
            android.view.View.OnClickListener {

//        public Context c;
        public Context c;

        public Dialog d;
        public Button yes, no;
        public EditText spent;
        String bid;
        int spnt;
        public CustomDialogClass(Context a,String bid,int spnt) {
            super(a);
            // TODO Auto-generated constructor stub
            this.c = a;
            this.bid =bid;
            this.spnt = spnt;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.custom_dialog);
            spent = (EditText) findViewById(R.id.spent);
            yes = (Button) findViewById(R.id.btn_yes);
            no = (Button) findViewById(R.id.btn_no);
            yes.setOnClickListener(this);
            no.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_yes:
                    dismiss();
                    break;
                case R.id.btn_no:
                    if(spent.getText().toString().equals("")) {
                        Toast.makeText(context,"please enter valid amount",Toast.LENGTH_LONG).show();
                    }
                    else {
                        dbHandler = new DBHandler(context);
                        spnt = spnt + Integer.parseInt(spent.getText().toString());
                       dbHandler.updateCourse(String.valueOf(spnt),bid);
                       HomeFragment.courseRVAdapter.notifyDataSetChanged();
                    }
                    break;
                default:
                    break;
            }
            dismiss();
        }
    }



}
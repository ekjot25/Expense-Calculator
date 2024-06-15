package com.astirmind.expense_pro;

public class CourseModal {

    private String budget_name;
    private String budget_id;

    public String getBudget_id() {
        return budget_id;
    }

    public void setBudget_id(String budget_id) {
        this.budget_id = budget_id;
    }

    private String budget_amount;
    private String budget_curr;
    private String budget_start_date;
    private String budget_reccurence;
    private String budget_spent;

    public CourseModal(String budget_name, String budget_amount, String budget_curr, String budget_start_date,String budget_reccurence, String budget_spent,String budget_id) {

        this.budget_name = budget_name;
        this.budget_amount = budget_amount;
        this.budget_curr = budget_curr;
        this.budget_start_date = budget_start_date;
        this.budget_reccurence = budget_reccurence;
        this.budget_spent = budget_spent;
        this.budget_id = budget_id;

    }

    public String getBudget_name() {
        return budget_name;
    }

    public void setBudget_name(String budget_name) {
        this.budget_name = budget_name;
    }

    public String getBudget_amount() {
        return budget_amount;
    }

    public void setBudget_amount(String budget_amount) {
        this.budget_amount = budget_amount;
    }

    public String getBudget_curr() {
        return budget_curr;
    }

    public void setBudget_curr(String budget_curr) {
        this.budget_curr = budget_curr;
    }

    public String getBudget_start_date() {
        return budget_start_date;
    }

    public void setBudget_start_date(String budget_start_date) {
        this.budget_start_date = budget_start_date;
    }

    public String getBudget_reccurence() {
        return budget_reccurence;
    }

    public void setBudget_reccurence(String budget_reccurence) {
        this.budget_reccurence = budget_reccurence;
    }

    public String getBudget_spent() {
        return budget_spent;
    }

    public void setBudget_spent(String budget_spent) {
        this.budget_spent = budget_spent;
    }






}

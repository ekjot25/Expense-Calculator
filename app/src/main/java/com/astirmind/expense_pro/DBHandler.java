package com.astirmind.expense_pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "Budget";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "budgettable";
    private static final String TABLE_NAME1 = "register";

    // below variable is for our id column.
    private static final String budget_id = "budget_id";


    // below variable is for our course name column
    private static final String budget_name = "budget_name";

    // below variable id for our course duration column.
    private static final String budget_amount = "budget_amount"
            ;
    private static final String budget_curr = "budget_curr";

    // below variable for our course description column.
    private static final String budget_start_date = "budget_start_date";

    // below variable is for our course tracks column.
    private static final String budget_reccurence = "budget_reccurence";

    private static final String budget_spent = "budget_spent";
    private static final String user_id = "user_id";
    private static final String username = "username";
    private static final String user_name = "user_name";
    private static final String user_email = "user_email";
    private static final String user_password = "user_password";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + budget_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + budget_name + " TEXT,"
                + budget_amount + " TEXT,"
                + budget_curr + " TEXT,"
                + budget_start_date + " TEXT,"
                + budget_reccurence + " TEXT,"
                + budget_spent + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);


        String query1 = "CREATE TABLE " + TABLE_NAME1+ " ("
                + user_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + username + " TEXT,"
                + user_name + " TEXT,"
                + user_email + " TEXT,"
                + user_password + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query1);
    }



    public void addUser(String usernamee, String userrname, String useremail,String userpassword) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(username, usernamee);
        values.put(user_name, userrname);
        values.put(user_email, useremail);
        values.put(user_password, userpassword);
        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME1, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }



    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String budgetname, String budgetamount, String budgetcurr,String budgetstart_date, String budgetreccurence) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(budget_name, budgetname);
        values.put(budget_amount, budgetamount);
        values.put(budget_curr, budgetcurr);
        values.put(budget_start_date, budgetstart_date);
        values.put(budget_reccurence, budgetreccurence);
        values.put(budget_spent, "0");

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public ArrayList<CourseModal> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();
//["budget_id", "budget_name", "budget_amount", "budget_curr", "budget_start_da...", +2 more]
        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(0)
                ));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }



    public void updateCourse(String originalCourseName,String bid) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(budget_spent, originalCourseName);


        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "budget_id=?", new String[]{bid});
        db.close();
    }



    public List<String>  getUser(String id) {

        SQLiteDatabase db = this.getReadableDatabase();
        List<String> contactList=new ArrayList<String>();


        Cursor cursorCourses = db.rawQuery("select * from register where user_id =" + "\""+ id.trim() + "\"", null);

        if (cursorCourses.moveToFirst()) {
            do {
                contactList.add(cursorCourses.getString(0));
                contactList.add(cursorCourses.getString(1));
                contactList.add(cursorCourses.getString(2));
                contactList.add(cursorCourses.getString(3));
                contactList.add(cursorCourses.getString(4));
            } while (cursorCourses.moveToNext());
        }

        cursorCourses.close();
        return contactList;
    }



    public String checkUser(String un, String pws) {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
//        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME1 +" WHERE "+ user_email + " = '" + un + "' and  "+ user_password + " = '" + pws+"'"  , null);
//        Cursor cursorCourses = db.rawQuery("SELECT * FROM register WHERE user_email='?' AND user_password='?'", new String[] {un, pws});
        Cursor cursorCourses = db.rawQuery("select * from register where user_email =" + "\""+ un.trim() + "\""+" and user_password="+ "\""+ pws.trim() + "\"", null);
        String st = "";
        if(cursorCourses.moveToFirst()) {

            st = cursorCourses.getString(0);
            cursorCourses.close();



            return st;
        } else {
            cursorCourses.close();
            return st;
        }



    }




}
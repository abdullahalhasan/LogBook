package com.abdullahalhasan.logbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Abdullah Al Hasan on 7/20/2016.
 */
public class UserManager {
    private User user;
    private DatabaseHelper helper;
    private Context context;
    private SQLiteDatabase database;

    public UserManager(Context context) {
        this.context = context;
        helper = new DatabaseHelper(context);
    }

    private void open() {

        database = helper.getWritableDatabase();

    }

    public boolean addUser(User user) {
        this.open();
        ContentValues contentValues = new ContentValues();

        String query = "SELECT * FROM"+DatabaseHelper.TABLE_USER;
        Cursor cursor = database.rawQuery(query,null);

        long count = cursor.getCount();

        contentValues.put(DatabaseHelper.COL_ID,count+1);
        contentValues.put(DatabaseHelper.COL_NAME,user.getName());
        contentValues.put(DatabaseHelper.COL_EMAIL,user.getEmail());
        contentValues.put(DatabaseHelper.COL_PASSWORD,user.getPassword());

        long inserted = database.insert(DatabaseHelper.TABLE_USER,null,contentValues);
        this.close();

        if(inserted>0) {
            return true;
        }

        else {
            return false;
        }
    }

    public Boolean searchPassword(String userPassword, String userEmail){

        this.open();

        String search = "SELECT "+DatabaseHelper.COL_EMAIL+", "+DatabaseHelper.COL_PASSWORD+"FROM "+DatabaseHelper.TABLE_USER
                +" WHERE "+DatabaseHelper.COL_PASSWORD+"='"+userPassword+"' AND "+DatabaseHelper.COL_EMAIL+"='"+userEmail+"'";
        if (search=="") {
            return false;
        }

        else {
            return true;
        }


    }


    private void close() {
        helper.close();
    }

}

package com.abdullahalhasan.logbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abdullah Al Hasan on 7/20/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME ="user_db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_USER = "user_table";
    static final String COL_ID ="id";
    static final String COL_NAME ="name";
    static final String COL_EMAIL ="email";
    static final String COL_PASSWORD ="password";
    Context context;

    static final String CREATE_USER_TABLE = "CREATE TABLE "+TABLE_USER+"( "
            +COL_ID+" INTEGER PRIMARY KEY,"
            +COL_NAME+" TEXT,"
            +COL_EMAIL+" TEXT,"
            +COL_PASSWORD+" TEXT )" ;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

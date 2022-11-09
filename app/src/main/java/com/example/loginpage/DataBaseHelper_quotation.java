package com.example.loginpage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper_quotation extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "quotation.db";
    public static final String TABLE_NAME = "ORDER APPROVAL";
    public static final String COL1 = "ORDER";
    public static final String COL2 = "PRICE";
    public static final String COL3 = "STATUS";

    public DataBaseHelper_quotation(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Take from what client chose
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

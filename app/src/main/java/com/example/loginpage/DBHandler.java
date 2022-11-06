package com.example.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creates a constant variables for our database
    private static final String DB_NAME = "inventoryDB";

    // database version number
    private static final int DB_VERSION = 1;

    // variable for our table name.
    private static final String TABLE_NAME = "inventory";

    // Variable for our item name column
    private static final String NAME_COL = "name";

    // variable for our item price column.
    private static final String PRICE_COL = "price";

    //constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // method for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        // creates an sqlite query
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + NAME_COL + " TEXT,"
                + PRICE_COL + " TEXT)";


        // executes our sql query
        db.execSQL(query);
    }

    // method used to add a new item and price to the DB
    public void addItem(String itemName, String itemPrice) {


        SQLiteDatabase db = this.getWritableDatabase();


        // variable for content values
        ContentValues values = new ContentValues();

        //puts item prices and item name into cv values
        values.put(NAME_COL, itemName);
        values.put(PRICE_COL, itemPrice);

        db.insert(TABLE_NAME, null, values);

        //closes database after adding
        db.close();
    }

    public void editItem(String itemName, String itemPrice) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(PRICE_COL,itemPrice);
        cv.put(NAME_COL,itemName);


        //db.update(TABLE_NAME, cv ,NAME_COL + " = " + itemName, null );

        db.update(TABLE_NAME, cv, "name = ?", new String[]{itemName});

        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // does the table exist already?
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
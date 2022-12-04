//*************************************************************************//
//adapted from: https://auth.geeksforgeeks.org/user/chaitanyamunje/articles//
//*************************************************************************//


package com.example.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import androidx.annotation.Nullable;


public class DBHandler extends SQLiteOpenHelper {

    private Context context;
    // creates a constant variable name for our database
    private static final String DB_NAME = "inventoryDB";

    // database version number
    private static final int DB_VERSION = 1;

    // table name variable
    private static final String TABLE_NAME = "inventory";

    // Variable for our item name column
    private static final String NAME_COL = "name";

    // Variable for our item name column
    private static final String PRICE_COL = "price";

    // constructor for our database handler.
    public DBHandler(@Nullable Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    // method for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + NAME_COL + " TEXT,"
                + PRICE_COL + " TEXT)";

        db.execSQL(query);
    }

    // method used to add a new item and price to the DB
    public void addItem(String itemName, String itemPrice) {

        // variable name for our database and calling the writable method onto it
        SQLiteDatabase db = this.getWritableDatabase();

        // creating variable for content values.
        ContentValues cv = new ContentValues();

        //puts item prices and item name into cv values variables
        cv.put(NAME_COL, itemName);
        cv.put(PRICE_COL, itemPrice);

        //  passes cv value variable  to the table.
        db.insert(TABLE_NAME, null, cv);

        // closes database after adding to database
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

    // checks to see if an item being added already exists
    public boolean compareitem(String itemName){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * FROM inventory",null, null);

        while (cursor.moveToNext()){
            if (cursor.getString(0).equals(itemName) ){

                cursor.close();

                return true;
            }
        }
        cursor.close();


        return false;
    }

    // deletes an item from the inventory
    void deleteItem(String itemName){

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "name = ?", new String[]{itemName});

        db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // checks to see if the table already exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    Cursor realData(){
        String query = "Select * FROM inventory";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null,null);
        }

        return cursor;
    }
}
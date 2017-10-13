package com.example.tharindu.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "list.db";
    private static final String TABLE_NAME = "mylist";
    private static final String COL1 = "ID";
    private static final String COL2 = "items";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable =  "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +  " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public int addData(String item){        //This method adds data to the table created
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);
        System.out.println(item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){      //Ensures wheather the data is inserted to the table correctly or not.
            return 0;
        }else{
            return 1;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public boolean deleteTable(){       //Delete all the rows in the table
        String query = "DELETE FROM " + TABLE_NAME;
        //String isEmpty = "SELECT COUNT(*) FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        //Cursor result = db.rawQuery(isEmpty, null);
        //result.moveToFirst();
        //int value = result.getInt(0);   //If value = 0 means table is empty.

        if(!isTableEmpty()){
            db.execSQL(query);
            return true;
        }
        return false;
    }

    public boolean isTableEmpty(){      //Check the table is empty or not.
        String isEmpty = "SELECT COUNT(*) FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery(isEmpty, null);
        result.moveToFirst();
        int value = result.getInt(0);
        if(value == 0){
            return true;
        }else{
            return false;
        }
    }


}

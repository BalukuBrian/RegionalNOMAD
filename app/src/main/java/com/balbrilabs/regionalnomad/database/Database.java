package com.balbrilabs.regionalnomad.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE userdetails(user_id integer primary key autoincrement, username VARCHAR(55), password VARCHAR(45))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE if exists userdetails");
    }

    //inserting data into the database
    public Boolean insertUserData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);


        long result = db.insert("userdetails", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //updating the database
    public Boolean updateUserData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        Cursor cursor = db.rawQuery("SELECT * FROM userdeatails WHERE username = ?", new String[]{username});


        if (cursor.getCount() > 0) {
            long result = db.update("userdetails", contentValues, "username=?", new String[]{username});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {

            return false;
        }
    }


    //deleting data
    public Boolean deleteUserData(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM userdeatails WHERE username = ?", new String[]{username});
        if (cursor.getCount() > 0) {

            long result = db.delete("userdetails", "username=?", new String[]{username});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {

            return false;
        }
    }


    //getting data
    public Cursor getUserData(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM userdeatails", null);
        return cursor;
    }


}

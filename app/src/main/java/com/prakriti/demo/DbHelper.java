package com.prakriti.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.prakriti.demo.UserInfo;

import java.util.ArrayList;


public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user";
    String info = "CREATE TABLE if not exists `user`  (\n" +
            "                       `id` INTEGER PRIMARY KEY AUTOINCREMENT ,\n" +
            "                       `first_name` TEXT,\n" +
            "                       `middle_name` TEXT,\n" +
            "                       `last_name` TEXT,\n" +
            "                       `address` TEXT,\n" +
            "                       `contact` TEXT,\n" +
            "                       `email` TEXT,\n" +
            "                       `username`TEXT,\n" +
            "                       `password`TEXT\n" +
            "                      );";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(info);
    }


    @Override
    public void onCreate(SQLiteDatabase _db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {

    }

    public void insertuserinfo(ContentValues cv) {
        getWritableDatabase().insert("user", "", cv);
    }


    public ArrayList<UserInfo> userInfos() {
        String sql = "select * from user";
        ArrayList<UserInfo> list = new ArrayList<UserInfo>();
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            UserInfo info = new UserInfo();
            info.id = cursor.getString(cursor.getColumnIndex("id"));
            info.first_name = cursor.getString(cursor.getColumnIndex("first_name"));
            info.middle_name = cursor.getString(cursor.getColumnIndex("middle_name"));
            info.last_name = cursor.getString(cursor.getColumnIndex("last_name"));
            info.address = cursor.getString(cursor.getColumnIndex("address"));
            info.contact = cursor.getString(cursor.getColumnIndex("contact"));
            info.email = cursor.getString(cursor.getColumnIndex("email"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));
            info.password = cursor.getString(cursor.getColumnIndex("password"));

            list.add(info);
        }
        cursor.close();
        return list;
    }

    public Integer delete(String id) {
        getWritableDatabase().delete("user", "id=" + id, null);

        return null;
    }

    public void deleteNotif(int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("user", "id=" + _id, null);
    }

    public boolean isValidUser(String username1, String password1) {
        String sql = "Select count(*) from user where username='" + username1 + "' and password='" + password1 + "'";
        SQLiteStatement sqLiteStatement = getWritableDatabase().compileStatement(sql);
        long l = sqLiteStatement.simpleQueryForLong();
        if (l > 0) {
            return true;
        } else return false;


    }
}


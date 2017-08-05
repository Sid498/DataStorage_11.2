package com.example.sid.datastorage_112;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SID on 8/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, "Product", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Createquery = "create table product(id integer primary key autoincrement,pname text)";
        sqLiteDatabase.execSQL(Createquery);
    }

    public long saveProduct(String name) {
        //adding data
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname", name);
        long id = sqLiteDatabase.insert("product", null, contentValues);
        return id;
    }

    public Cursor showProduct() {
        //fetching data
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from product", null);
        if (cursor != null)
            return cursor;
        else
            return null;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

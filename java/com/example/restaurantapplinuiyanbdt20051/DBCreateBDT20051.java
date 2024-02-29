package com.example.restaurantapplinuiyanbdt20051;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBCreateBDT20051 extends SQLiteOpenHelper{
    public static final String DB_NAME = "mydatabase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "menu";
    public static final String ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";
    public DBCreateBDT20051(@Nullable Context context){
        super(context, DB_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建菜单表
        String createTableQuery = "CREATE TABLE menu (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, price REAL)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

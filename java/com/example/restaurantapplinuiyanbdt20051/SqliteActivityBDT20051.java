package com.example.restaurantapplinuiyanbdt20051;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SqliteActivityBDT20051 extends AppCompatActivity {
    ListView lv;
    public ArrayList<String> data;
    public ArrayAdapter<String> adapter;

    Button mBtnCreateDB;
    Button mBtnDeleteDB, mBtnUpData;
    Button mBtnadd, mBtnShow;

    DBCreateBDT20051 mDbCreatePhone;
    SQLiteDatabase msqLiteDatabase;
    TextView textView;
    ContentValues contentValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_bdt20051);
        lv = findViewById(R.id.lvlinuoyan);
        data = getData();//通过getData函数获取值
        adapter = new ArrayAdapter<String>(SqliteActivityBDT20051.this, android.R.layout.simple_list_item_multiple_choice,data);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(adapter);//在listview加入适配器
        lv.setOnItemClickListener(new lvClick());//为listview设置事件监听
        mBtnCreateDB = findViewById(R.id.create_databaseslinuoayan);
        mBtnDeleteDB = findViewById(R.id.delete_databaseslinuoyan);
        mBtnadd = findViewById(R.id.add_databaseslinuoyan);
        textView = findViewById(R.id.menuTextViewlinuoyan);
        mBtnShow = findViewById(R.id.show);

        mBtnCreateDB.setOnClickListener(new myClick());
        mBtnDeleteDB.setOnClickListener(new myClick());
        mBtnadd.setOnClickListener(new myClick());
        mBtnShow.setOnClickListener(new myClick());
    }
    String information = "";
    class lvClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            TextView tv = (TextView) view;
            information += tv.getText().toString();
            String information2="您已经点了"+(information);
            Toast toast = Toast.makeText(SqliteActivityBDT20051.this,information2,Toast.LENGTH_LONG);
            toast.show();
        }
    }
    public ArrayList<String>getData()
    {
        ArrayList<String> d = new ArrayList<>();
        d.add("面包");
        d.add("披萨");
        d.add("牛奶");
        d.add("绿茶");
        d.add("牛肉");
        d.add("米饭");
        d.add("串串");
        d.add("包子");
        d.add("汉堡");
        return d;
    }
    class myClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view == mBtnDeleteDB) {
                try {
                    deleteDatabase(DBCreateBDT20051.DB_NAME);
                    toastMessage("删除成功");
                }
                catch (Exception e) {
                    toastMessage("删除失败" + e.getMessage());
                }
            }
            if (view == mBtnCreateDB) {
                try {
                    mDbCreatePhone = new DBCreateBDT20051(SqliteActivityBDT20051.this);
                    msqLiteDatabase = mDbCreatePhone.getWritableDatabase();
                    toastMessage("创建数据库成功");
                    Intent intent = new Intent();
                    intent.setClass(SqliteActivityBDT20051.this, RiceActivityBDT20051.class);
                    Toast.makeText(SqliteActivityBDT20051.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } catch (Exception e) {
                    toastMessage("创建数据库失败" + e.getMessage());
                }
            }
            if (view == mBtnadd) {
                try {
                    contentValues = new ContentValues();
                    contentValues.put(DBCreateBDT20051.COLUMN_NAME, information);
//                    contentValues.put(DBCreate.COLUMN_PRICE, "100");
                    mDbCreatePhone = new DBCreateBDT20051(SqliteActivityBDT20051.this);
                    msqLiteDatabase = mDbCreatePhone.getWritableDatabase();
                    msqLiteDatabase.insert(DBCreateBDT20051.TABLE_NAME, null, contentValues);
                    toastMessage("插入数据成功");
                } catch (Exception e) {
                    toastMessage("插入数据失败" + e.getMessage());
                }
            }
            if (view == mBtnShow) {
                try {
                    Cursor cursor = getDishes();
                    String show = " ";
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
//                                int dishId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                            String dishName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
//                                double dishPrice = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))
                            textView.setText("你已经点了"+dishName);
                        }
                        cursor.close();
                        toastMessage("查询成功");
                    }
                } catch (Exception e) {
                    toastMessage("查询失败" + e.getMessage());
                }
            }
        }
    }

    public void toastMessage(String message)
    {
        Toast toast = Toast.makeText(SqliteActivityBDT20051.this,message,Toast.LENGTH_SHORT);
        toast.show();
    }
    public Cursor getDishes() {
        SQLiteDatabase db = mDbCreatePhone.getReadableDatabase();
        String[] projection = {"id", "name", "price"};
        String sortOrder = "id ASC";
        return db.query("menu", projection, null, null, null, null, sortOrder);
    }

}
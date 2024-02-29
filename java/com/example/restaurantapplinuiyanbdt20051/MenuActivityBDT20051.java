package com.example.restaurantapplinuiyanbdt20051;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivityBDT20051 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bdt20051);
        GridView gridView = (GridView) findViewById(R.id.GridView_linuoyan);
        ArrayList<HashMap<String,Object>> meumList = new ArrayList<HashMap<String, Object>>();
        for(int i = 1; i < 13; i++){
            HashMap<String,Object> map = new HashMap<String, Object>();

            if(i>=1&&i<=3) {
                map.put("ItemImage", R.drawable.menu1);
                meumList.add(map);
                if (i==3){map.put("ItemText",""+"video");}
                else if (i==2){map.put("ItemText",""+"music");}
                else if (i==1){map.put("ItemText",""+"menu");}

            }
            if(i>=4&&i<=6) {
                map.put("ItemImage", R.drawable.menu2);
                meumList.add(map);
                if (i==4){map.put("ItemText",""+"Internet");}
                else if (i==5){map.put("ItemText",""+"music");}
                else if (i==6){map.put("ItemText",""+"menu");}
            }
            if(i>=7&&i<=9) {
                map.put("ItemImage", R.drawable.menu3);
                meumList.add(map);
                map.put("ItemText",""+i);
            }
            if(i>=10&&i<=12){
                meumList.add(map);}
        }

        // 构建数据适配器
        SimpleAdapter saItem = new SimpleAdapter(this, meumList, R.layout.itembdt20051, new String[]{"ItemImage","ItemText"},
                new int[]{R.id.ItemImagelinuoyan,R.id.ItemTextlinuoyan});
        // 应用适配器
        gridView.setAdapter(saItem);
        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @SuppressLint("WrongConstant")
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        int index = arg2 + 1;
                        Toast.makeText(getApplicationContext(),"点击了选项：" + index,0).show();
                        if (index == 1)
                        {
                            Intent intent = new Intent();
                            intent.setClass(MenuActivityBDT20051.this, SqliteActivityBDT20051.class);
                            startActivity(intent);
                        }
                        if (index == 2)
                        {
                            Intent intent = new Intent();
                            intent.setClass(MenuActivityBDT20051.this, MusicActivityBDT20051.class);
                            startActivity(intent);
                        }
                        if (index == 3)
                        {
                            Intent intent = new Intent();
                            intent.setClass(MenuActivityBDT20051.this, VideoActivityBDT20051.class);
                            startActivity(intent);
                        }
                        if (index == 4)
                        {
                            Intent intent = new Intent();
                            intent.setClass(MenuActivityBDT20051.this, WebActivityBDT20051.class);
                            startActivity(intent);
                        }

                    }
                }
        );

    }


    }

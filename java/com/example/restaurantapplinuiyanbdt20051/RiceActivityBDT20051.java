package com.example.restaurantapplinuiyanbdt20051;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RiceActivityBDT20051 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<FoodBDT20051> foodList = new ArrayList<>();
    FoodAdapterBDT20051 foodAdapter;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_bdt20051);
        recyclerView = findViewById(R.id.rclinuoyan);
        foodList= initData();
        foodAdapter = new FoodAdapterBDT20051(foodList);
        btn = findViewById(R.id.buttonlinuoyan);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(foodAdapter);
        btn.setOnClickListener(new myClick());
    }
    class myClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(RiceActivityBDT20051.this, SqliteActivityBDT20051.class);
            Toast.makeText(RiceActivityBDT20051.this, "登录成功", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
    public List<FoodBDT20051> initData()
    {
        List<FoodBDT20051> foods = new ArrayList<>();
        FoodBDT20051 food1 = new FoodBDT20051(R.drawable.bread,"面包--2.0");
        foods.add(food1);
        FoodBDT20051 food2 = new FoodBDT20051(R.drawable.hamburger,"汉堡--5.5");
        foods.add(food2);
        FoodBDT20051 food3 = new FoodBDT20051(R.drawable.milk,"奶茶--3.0");
        foods.add(food3);
        FoodBDT20051 food4 = new FoodBDT20051(R.drawable.tea,"绿茶--1.5" );
        foods.add(food4);
        FoodBDT20051 food5 = new FoodBDT20051(R.drawable.meat,"牛肉--8.8" );
        foods.add(food5);
        FoodBDT20051 food6 = new FoodBDT20051(R.drawable.shousi,"寿司--9.0" );
        foods.add(food6);
        FoodBDT20051 food7 = new FoodBDT20051(R.drawable.mice,"米饭--1.0" );
        foods.add(food7);
        FoodBDT20051 food8 = new FoodBDT20051(R.drawable.pisa,"披萨--2.0" );
        foods.add(food8);
        FoodBDT20051 food9 = new FoodBDT20051(R.drawable.tiantianquan,"甜圈--2.0" );
        foods.add(food9);
        FoodBDT20051 food10 = new FoodBDT20051(R.drawable.baozi,"包子--1.0" );
        foods.add(food10);
        FoodBDT20051 food11 = new FoodBDT20051(R.drawable.chuanchuan,"串串--2.0" );
        foods.add(food11);
        FoodBDT20051 food12 = new FoodBDT20051(R.drawable.niunai,"牛奶--2.0" );
        foods.add(food12);

        return foods;

    }
}
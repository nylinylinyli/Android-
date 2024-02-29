package com.example.restaurantapplinuiyanbdt20051;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivityBDT20051 extends AppCompatActivity {
    Button register_btn,backToFirst_btn;
    EditText edittext_name,edittext_password;
    SharedPreferences mSharedPreferences;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_bdt20051);
        edittext_name = findViewById(R.id.edittext_name_linuoyan);
        edittext_password = findViewById(R.id.edittext_password_linuoyan);
        backToFirst_btn  = findViewById(R.id.backToFirst_btn_linuoyan);
        register_btn = findViewById(R.id.register_btn_linuoyan);
        mSharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);

        String rummage_name = mSharedPreferences.getString("name","");
        int rummage_pwd = mSharedPreferences.getInt("pwd",0);

        register_btn.setOnClickListener(new myClick());
        backToFirst_btn.setOnClickListener(new myClick());
    }
    class myClick implements  View.OnClickListener {

        @Override
        public void onClick(View view) {

            if (view == register_btn)
            {
                try {
                    String name = edittext_name.getText().toString();
                    String pwd = edittext_password.getText().toString();
                    int int_pwd = Integer.parseInt(pwd);
                    mSharedPreferences.edit().putString("name",name).apply();
                    mSharedPreferences.edit().putInt("pwd",int_pwd).apply();
                } catch (Exception e) {
                    Toast.makeText(RegisterActivityBDT20051.this,"注册失败",Toast.LENGTH_SHORT).show();
                }


            }
            if (view == backToFirst_btn)
            {
                Intent intent = new Intent();
                intent.setClass(RegisterActivityBDT20051.this,MainActivity.class);
                startActivity(intent);

            }
        }
    }
}
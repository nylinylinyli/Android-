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

public class MainActivity extends AppCompatActivity {
    Intent mainintent;
    TextView tv;
    EditText editText,editText2,editText3;
    Button btn1,btn2;
    Bundle mBundle;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittext_linuoyan01);
        editText2 = findViewById(R.id.edittext_linuoayn02);
        tv = findViewById(R.id.linuoyan_tv);
        btn1 = findViewById(R.id.linuoyan_btn1);
        btn2 = findViewById(R.id.linuoyan_btn2);
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
        btn1.setOnClickListener(new myClick());
        btn2.setOnClickListener(new myClick());

    }class myClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == btn1) {
                String rummage_name = sharedPreferences.getString("name", "");
                int rummage_pwd = sharedPreferences.getInt("pwd",0);
                String name = editText.getText().toString();
                int pwd = Integer.parseInt(editText2.getText().toString());
                if (name.equals(rummage_name)&& pwd ==rummage_pwd) {
                    if (name.isEmpty() ) {
                        showMsg("输入值不能为空！");
                    } else {
                        Intent intent = new Intent();
                        tv.setText("成功");
                        intent.setClass(MainActivity.this, MenuActivityBDT20051.class);
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                } else {
                    tv.setText("失败");
                    showMsg("密码有误，登录失败");

                }
            }

            if (v == btn2) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RegisterActivityBDT20051.class);
                startActivity(intent);
            }


        }
    }

    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

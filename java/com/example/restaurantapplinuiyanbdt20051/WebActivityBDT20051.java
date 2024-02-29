package com.example.restaurantapplinuiyanbdt20051;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class WebActivityBDT20051 extends AppCompatActivity {
    Button btnYes;
    ImageButton btn_back;
    EditText web_editText;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_bdt20051);
        btnYes=(Button)findViewById(R.id.btn_yeslinuoyan);
        btn_back =(ImageButton)findViewById(R.id.btn_backlinuoyan);
//        web_editText= findViewById(R.id.web_textlinuoyan);
        webView=(WebView)findViewById(R.id.webviewlinuoyan);
        btnYes.setOnClickListener(new myClick());
        btn_back.setOnClickListener(new myClick());
    }
    class myClick implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            if(v==btnYes) {
                String url = "https://www.sina.com.cn";
//              String url = "http://www.baidu.com";
//                webView.loadUrl(url);
//                webView.setWebViewClient(new WebViewClient());
//                String url = "https://"+etUrl.getText().toString();
                webView.loadUrl(url);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
            }
            if(v==btn_back)
            {
                Intent intent = new Intent();
                intent.setClass(WebActivityBDT20051.this,MenuActivityBDT20051.class);
                startActivity(intent);
            }

        }
    }

    class test extends WebViewClient
    {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) //Android 5.0
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
        {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}
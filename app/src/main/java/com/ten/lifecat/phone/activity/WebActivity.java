package com.ten.lifecat.phone.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ten.lifecat.phone.R;

/**
 * @author 59682
 * @name WebActivity
 * @description 浏览器访问官网
 */
public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        /* 设置浏览器 */
        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://111.230.244.153:8080/lifecatweb/imageshow.jsp");
    }
}

package com.ten.lifecat.phone.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ten.lifecat.phone.R;

/**
 * WEB浏览器界面
 */
public class WebActivity extends AppCompatActivity {

    private static final String WEB_URL = "http://111.230.244.153:8080/lifecatweb/imageshow.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(WEB_URL);
    }
}

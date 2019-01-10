package com.ten.lifecat.phone.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

import com.ten.lifecat.phone.R

/**
 * WEB浏览器界面
 */
class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val webView = findViewById<WebView>(R.id.web_view)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl(WEB_URL)
    }

    companion object {

        private val WEB_URL = "http://111.230.244.153:8080/lifecatweb/imageshow.jsp"
    }
}

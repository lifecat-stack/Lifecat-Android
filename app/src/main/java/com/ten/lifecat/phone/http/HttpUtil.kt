package com.ten.lifecat.phone.http

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

import javax.security.auth.callback.Callback

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


object HttpUtil {

    /**
     * HttpURLConnection手动实现连接
     */
    fun sendHttpRequest(address: String, listener: HttpCallbackListener?) {
        Thread {
            var connection: HttpURLConnection? = null
            try {
                val url = URL(address)
                connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                connection.doInput = true
                connection.doOutput = true

                /* 获取响应输入流 */
                val `in` = connection.inputStream
                val reader = BufferedReader(InputStreamReader(`in`))
                val response = StringBuilder()

                while (reader.readLine() != null) {
                    response.append(reader.readLine())
                }

                listener?.onFinish(response.toString())
            } catch (e: Exception) {
                listener?.onError(e)
            } finally {
                connection?.disconnect()
            }
        }.start()
    }

    /**
     * @description OkHttp方法 内置Callback回调对象
     */
    fun sendOkHttpRequest(address: String, callback: okhttp3.Callback) {
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(address)
                .build()
        /* OkHttp开启子线程，请求结果回调到Callback中 */
        client.newCall(request).enqueue(callback)
    }
}

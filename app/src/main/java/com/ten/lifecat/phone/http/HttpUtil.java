//package com.ten.lifecat.myapplicationtest2018421.http;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import javax.security.auth.callback.Callback;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// * @name HttpUtil
// * @description 网络请求类
// * @author 59682
// */
//public class HttpUtil {
//
//    /**
//     * @description HttpURLConnection手动实现连接
//     */
//    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                HttpURLConnection connection=null;
//                try {
//                    URL url = new URL(address);
//                    connection = (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("GET");
//                    connection.setConnectTimeout(8000);
//                    connection.setReadTimeout(8000);
//                    connection.setDoInput(true);
//                    connection.setDoOutput(true);
//
//                    /* 获取响应输入流 */
//                    InputStream in = connection.getInputStream();
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        response.append(line);
//                    }
//                    if (listener != null) {
//                        /* 回调onFinish方法 */
//                        listener.onFinish(response.toString());
//                    }
//                }catch (Exception e) {
//                    if (listener != null) {
//                        /* 回调onError方法 */
//                        listener.onError(e);
//                    }
//                }finally {
//                    if (connection!=null){
//                        connection.disconnect();
//                    }
//                }
//            }
//        }).start();
//    }
//
//    /**
//     * @description OkHttp方法 内置Callback回调对象
//     */
//    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
//        OkHttpClient client=new OkHttpClient();
//        Request request=new Request.Builder()
//                .url(address)
//                .build();
//        /* OkHttp开启子线程，请求结果回调到Callback中 */
//        client.newCall(request).enqueue(callback);
//    }
//}

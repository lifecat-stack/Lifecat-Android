//package com.ten.lifecat.myapplicationtest2018421;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import java.io.IOException;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// * @author 59682
// * @name HttpActivity
// * @description 网络请求界面
// */
//public class HttpActivity extends AppCompatActivity implements View.OnClickListener {
//
//    TextView responseText;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_http);
//
//        assignView();
//    }
//
//    /**
//     * @description get-view
//     */
//    private void assignView() {
//        Button sendRequest = findViewById(R.id.send_request);
//        responseText = findViewById(R.id.response_text);
//        sendRequest.setOnClickListener(this);
//    }
//
//    /**
//     * @description button-click
//     */
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.send_request) {
//            sendRequestWithOkHttp();
//        }
//    }
//
//    /**
//     * @description 开启线程来发送网络请求
//     */
//    private void sendRequestWithOkHttp() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    OkHttpClient client = new OkHttpClient();
//                    Request request = new Request.Builder()
//                            .url("http://111.230.244.153:8080/lifecatweb")
//                            .build();
//                    Response response=client.newCall(request).execute();
//                    String responseData=response.body().string();
//                    showResponse(responseData);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    /**
//     * @description 将response内容显示到view
//     */
//    private void showResponse(final String response){
//        /* runOnUiThread-->UI操作只能在主线程中操作 */
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                responseText.setText(response);
//            }
//        });
//    }
//}

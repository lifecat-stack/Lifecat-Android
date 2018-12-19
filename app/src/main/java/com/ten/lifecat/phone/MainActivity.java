package com.ten.lifecat.phone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ten.lifecat.phone.activity.PhotoActivity;
import com.ten.lifecat.phone.activity.UploadActivity;
import com.ten.lifecat.phone.activity.WebActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 59682
 * @name MainActivity
 * @description User个人信息 profile界面
 */
public class MainActivity extends AppCompatActivity {

    //Msg序列
    private List<Msg> msgList = new ArrayList<>();
    //输入信息
    private EditText inputText;
    //发送按钮
    private Button send;
    //获取RecyclerView实例
    private RecyclerView msgRecyclerView;
    //获取适配器实例
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 设置bar左侧按钮 */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航按钮
//            actionBar.setHomeAsUpIndicator(R.mipmap.navigation);
        }

        /* 设置toolbar */
        Toolbar toolbar = findViewById(com.ten.lifecat.phone.R.id.talking_toolbar);
        setSupportActionBar(toolbar);

        //-------------------------Talking类代码
        //聊天信息初始化
        initMsgs();
        //取得实例
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        //定义管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //向ReceyclerView添加管理器
        msgRecyclerView.setLayoutManager(layoutManager);
        //获得适配器
        adapter = new MsgAdapter(msgList);
        //设置适配器
        msgRecyclerView.setAdapter(adapter);
        //发送按钮的监听事件
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {

                    Msg msgr = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msgr);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    //msgRecyclerView.scrollToPosition(msgList.size()-2);

                    //回应
                    Msg msgl = new Msg(Msg.TYPE_RECEIVED);
                    msgList.add(msgl);
                    adapter.notifyItemInserted(msgList.size() - 1);

                    inputText.setText("");

                    //跳转
                    if (content.contains("上传") || content.contains("up")) {
                        // 创建Intent对象
                        Intent intent = new Intent();
                        // 设置要跳转的页面
                        intent.setClass(MainActivity.this, UploadActivity.class);
                        // 开始Activity
                        startActivity(intent);
                    } else if (content.contains("相册") || content.contains("photo")) {
                        // 创建Intent对象
                        Intent intent = new Intent();
                        // 设置要跳转的页面
                        intent.setClass(MainActivity.this, PhotoActivity.class);
                        // 开始Activity
                        startActivity(intent);
                    } else if (content.contains("网页") || content.contains("web")) {
                        // 创建Intent对象
                        Intent intent = new Intent();
                        // 设置要跳转的页面
                        intent.setClass(MainActivity.this, WebActivity.class);
                        // 开始Activity
                        startActivity(intent);
                    }
                }
            }

        });
    }

    //聊天界面初始化
    private void initMsgs() {
        Msg msg1 = new Msg("你好,请使用!", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("嗨,LifeCat", Msg.TYPE_SENT);
        msgList.add(msg2);
//        Msg msg3 = new Msg("This is Mr.wang.Nice talking to you.", Msg.TYPE_RECEIVED);
//        msgList.add(msg3);
        //Talking类代码
    }
}

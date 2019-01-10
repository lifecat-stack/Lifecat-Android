package com.ten.lifecat.phone.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.ten.lifecat.phone.model.bean.Msg
import com.ten.lifecat.phone.view.fragment.adapter.MsgAdapter
import com.ten.lifecat.phone.R

import java.util.ArrayList

/**
 * @author 59682
 * @name UserProfileActivity
 * @description User个人信息 profile界面
 */
class UserProfileActivity : AppCompatActivity() {

    //Msg序列
    private val msgList = ArrayList<Msg>()
    //输入信息
    private var inputText: EditText? = null
    //发送按钮
    private var send: Button? = null
    //获取RecyclerView实例
    private var msgRecyclerView: RecyclerView? = null
    //获取适配器实例
    private var adapter: MsgAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* 设置bar左侧按钮 */
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        /* 设置toolbar */
        val toolbar = findViewById<Toolbar>(R.id.talking_toolbar)
        setSupportActionBar(toolbar)

        //-------------------------Talking类代码
        //聊天信息初始化
        initMsgs()
        //取得实例
        inputText = findViewById<View>(R.id.input_text) as EditText
        send = findViewById<View>(R.id.send) as Button
        msgRecyclerView = findViewById<View>(R.id.msg_recycler_view) as RecyclerView
        //定义管理器
        val layoutManager = LinearLayoutManager(this)
        //向ReceyclerView添加管理器
        msgRecyclerView!!.layoutManager = layoutManager
        //获得适配器
        adapter = MsgAdapter(msgList)
        //设置适配器
        msgRecyclerView!!.adapter = adapter
        //发送按钮的监听事件
        send!!.setOnClickListener {
            val content = inputText!!.text.toString()
            if ("" != content) {

                val msgr = Msg(content, Msg.TYPE_SENT)
                msgList.add(msgr)
                adapter!!.notifyItemInserted(msgList.size - 1)
                //msgRecyclerView.scrollToPosition(msgList.size()-2);

                //回应
                val msgl = Msg("", Msg.TYPE_RECEIVED)
                msgList.add(msgl)
                adapter!!.notifyItemInserted(msgList.size - 1)

                inputText!!.setText("")

                //跳转
                if (content.contains("上传") || content.contains("up")) {
                    // 创建Intent对象
                    val intent = Intent()
                    // 设置要跳转的页面
                    intent.setClass(this@UserProfileActivity, UploadActivity::class.java)
                    // 开始Activity
                    startActivity(intent)
                } else if (content.contains("相册") || content.contains("photo")) {
                    // 创建Intent对象
                    val intent = Intent()
                    // 设置要跳转的页面
                    intent.setClass(this@UserProfileActivity, PhotoActivity::class.java)
                    // 开始Activity
                    startActivity(intent)
                } else if (content.contains("网页") || content.contains("web")) {
                    // 创建Intent对象
                    val intent = Intent()
                    // 设置要跳转的页面
                    intent.setClass(this@UserProfileActivity, WebActivity::class.java)
                    // 开始Activity
                    startActivity(intent)
                }
            }
        }
    }

    //聊天界面初始化
    private fun initMsgs() {
        val msg1 = Msg("你好,请使用!", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("嗨,LifeCat", Msg.TYPE_SENT)
        msgList.add(msg2)
        //        Msg msg3 = new Msg("This is Mr.wang.Nice talking to you.", Msg.TYPE_RECEIVED);
        //        msgList.add(msg3);
        //Talking类代码
    }
}

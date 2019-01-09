package com.ten.lifecat.phone.activity

import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView

import com.ten.lifecat.phone.R

import java.io.FileNotFoundException

/**
 * 图片上传界面
 */
class UploadActivity : AppCompatActivity() {

    private var Browse: Button? = null
    private var Images: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        /* 设置toolbar */
        val toolbar = findViewById<Toolbar>(R.id.upload_toolbar)
        setSupportActionBar(toolbar)

        /* 设置bar左侧按钮 */
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        init()

        /* 点击打开UpLoadImage，使用Album进行上传 */
        Browse!!.setOnClickListener { view ->
            val intent = Intent()
            intent.setClass(this@UploadActivity, UploadImage::class.java)
            startActivity(intent)
        }
    }

    /* 初始化 */
    private fun init() {
        Browse = findViewById(R.id.browse)
        Images = findViewById<View>(R.id.camera_image) as ImageView
    }

    /* 选取并展示 ？ */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Activity.RESULT_OK) {
            val uri = data!!.data
            val cr = this.contentResolver
            try {//压缩图片
                val mBitmap = BitmapFactory.decodeStream(cr.openInputStream(uri!!))
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    /**
     * 设置menu点击事件
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            /* 返回键 */
            R.id.backup -> {
                val intentBackup = Intent()
                intentBackup.setClass(this@UploadActivity, LoginActivity::class.java)
                startActivity(intentBackup)
            }
            /* web键 */
            R.id.web -> {
                val intent_web = Intent()
                intent_web.setClass(this@UploadActivity, WebActivity::class.java)
                startActivity(intent_web)
            }
            /* home键 */
            R.id.home -> {
                val intent_home = Intent()
                intent_home.setClass(this@UploadActivity, BackgroundActivity::class.java)
                startActivity(intent_home)
            }
            else -> {
            }
        }
        return true
    }
}

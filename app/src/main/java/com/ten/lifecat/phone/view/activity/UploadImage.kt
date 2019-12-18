package com.ten.lifecat.phone.view.activity


import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.ten.lifecat.phone.R
import com.yanzhenjie.album.Album

/**
 * 使用Album进行照片选取
 */
class UploadImage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Album.startAlbum(this, Activity.RESULT_OK, 9, ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorPrimaryDark))// 指定选择数量
        // 指定Toolbar的颜色
        // 指定状态栏的颜色
    }

    /**
     * 回调 :用户相册操作结束
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == Activity.RESULT_OK) {
            // 图片选择成功
            if (resultCode == Activity.RESULT_OK) {
                // 用户选择的图片路径List
                val pathList = Album.parseResult(data!!)
                println("用户选择的图片路径: $pathList")
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "已取消图片选择", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "图片选择失败", Toast.LENGTH_LONG).show()
            }// 图片选择失败
            // 用户取消选择
        } else {
            Toast.makeText(this, "图片选择请求码错误", Toast.LENGTH_LONG).show()
        }
    }
}

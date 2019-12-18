package com.ten.lifecat.phone.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

import com.ten.lifecat.phone.model.bean.Photo
import com.ten.lifecat.phone.view.adapter.PhotoAdapter
import com.ten.lifecat.phone.R

import java.util.ArrayList

/**
 * 图片展示界面
 */
class PhotoActivity : AppCompatActivity() {
    /* 适配器数据集 */
    private val photoList = ArrayList<Photo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        // toolbar
        val toolbar = findViewById<Toolbar>(R.id.photo_toolbar)
        setSupportActionBar(toolbar)

        // bar左侧按钮
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        /* 初始化数据集 */
        initPhotos()

        /* 获取listview布局实例 */
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.photo_recyclerview)

        /* 设置卡片式布局管理器 */
        val layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        /* 设置item适配器 */
        val adapter = PhotoAdapter(photoList)
        recyclerView.adapter = adapter
    }

    /**
     * 获取数据集
     */
    private fun initPhotos() {
        //        String path = "D:\\Android\\AndroidProjects\\LifeCat\\app\\src\\main\\res\\images\\";
        //        File directory = new File(path);
        //        File[] files = directory.listFiles();
        for (i in ids.indices) {
            val photo = Photo(i.toString() + "", ids[i])
            photoList.add(photo)
        }
    }

    /**
     * 设置菜单menu
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    /**
     * 设置menu点击事件
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            /* 返回键 */
            R.id.backup -> {
                val intent_backup = Intent()
                intent_backup.setClass(this@PhotoActivity, LoginActivity::class.java)
                startActivity(intent_backup)
            }
            /* web键 */
            R.id.web -> {
                val intent_web = Intent()
                intent_web.setClass(this@PhotoActivity, WebActivity::class.java)
                startActivity(intent_web)
            }
            /* home键 */
            R.id.home -> {
                val intent_home = Intent()
                intent_home.setClass(this@PhotoActivity, BackgroundActivity::class.java)
                startActivity(intent_home)
            }
        }
        return true
    }

    companion object {

        private val ids = intArrayOf(R.drawable.image0, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16, R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20, R.drawable.image30, R.drawable.image31, R.drawable.image32, R.drawable.image33, R.drawable.image34, R.drawable.image35, R.drawable.image36, R.drawable.image37, R.drawable.image38, R.drawable.image39, R.drawable.image40, R.drawable.image41, R.drawable.image42, R.drawable.image43, R.drawable.image44, R.drawable.image45, R.drawable.image46, R.drawable.image47, R.drawable.image48, R.drawable.image49, R.drawable.image50, R.drawable.image51, R.drawable.image52, R.drawable.image53, R.drawable.image54, R.drawable.image55, R.drawable.image56, R.drawable.image57, R.drawable.image58, R.drawable.image59, R.drawable.image60, R.drawable.image61, R.drawable.image62, R.drawable.image63, R.drawable.image64, R.drawable.image65, R.drawable.image66, R.drawable.image67, R.drawable.image68, R.drawable.image69, R.drawable.image70, R.drawable.image71, R.drawable.image72, R.drawable.image73, R.drawable.image74, R.drawable.image75, R.drawable.image76, R.drawable.image77, R.drawable.image78, R.drawable.image79, R.drawable.image80, R.drawable.image81, R.drawable.image82, R.drawable.image83, R.drawable.image84, R.drawable.image85, R.drawable.image86)
    }
}

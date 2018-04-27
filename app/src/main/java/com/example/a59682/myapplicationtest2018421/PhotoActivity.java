package com.example.a59682.myapplicationtest2018421;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 59682
 * @name PhotoActivity
 * @description 图片展示界面
 */
public class PhotoActivity extends AppCompatActivity {
    /* 适配器数据集 */
    private List<Photo> photoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        /* 设置toolbar */
        Toolbar toolbar = findViewById(R.id.photo_toolbar);
        setSupportActionBar(toolbar);

        /* 设置bar左侧按钮 */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航按钮
//            actionBar.setHomeAsUpIndicator(R.mipmap.navigation);
        }

        /* 初始化数据集 */
        initPhotos();

        /* 获取listview布局实例 */
        RecyclerView recyclerView = findViewById(R.id.photo_recyclerview);

        /* 设置卡片式布局管理器 */
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        /* 设置item适配器 */
        PhotoAdapter adapter = new PhotoAdapter(photoList);
        recyclerView.setAdapter(adapter);
    }

    /**
     * @description 获取数据集
     */
    private void initPhotos() {
        for (int i = 0; i < 50; i++) {
            Photo photo1 = new Photo("apple", R.drawable.image1);
            photoList.add(photo1);
            Photo photo2 = new Photo("banana", R.drawable.image2);
            photoList.add(photo2);
            Photo photo3 = new Photo("orange", R.drawable.images);
            photoList.add(photo3);
        }
    }


    /**
     * @description 设置菜单menu
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     * @description 设置menu点击事件
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /* 返回键 */
            case R.id.backup:
                Intent intent_backup = new Intent();
                intent_backup.setClass(PhotoActivity.this, LoginActivity.class);
                startActivity(intent_backup);
                break;
            /* web键 */
            case R.id.web:
                Intent intent_web = new Intent();
                intent_web.setClass(PhotoActivity.this, WebActivity.class);
                startActivity(intent_web);
                break;
            /* home键 */
            case R.id.home:
                Intent intent_home = new Intent();
                intent_home.setClass(PhotoActivity.this, BackgroundActivity.class);
                startActivity(intent_home);
                break;
        }
        return true;
    }
}

package com.example.a59682.myapplicationtest2018421;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * @author 59682
 * @name BackgroundActivity
 * @description 背景界面操作
 */
public class BackgroundActivity extends AppCompatActivity {

    private Button button_upload;
    private Button button_web;
    private Button button_photo;

    /* 导航按钮 */
    private DrawerLayout mDrawerLayout;

    /**
     * @description 设置主界面
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        /* 设置toolbar */
        Toolbar toolbar = findViewById(R.id.background_toolbar);
        setSupportActionBar(toolbar);

        /* 设置NavigationView导航栏 */
        mDrawerLayout = findViewById(R.id.drawer_layout);

        /* 设置导航栏 */
        setNavigation();

        /* 设置点击事件 */
        assignViews();
        initListener();
    }

    /**
     * @description 设置导航栏
     */
    private void setNavigation() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        /* 设置导航按钮 */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航按钮
            //actionBar.setHomeAsUpIndicator(R.mipmap.navigation);
        }

        /* 设置默认激活按钮 */
        navigationView.setCheckedItem(R.id.nav_profile);

        /* 导航栏点击事件 */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = new Intent();
                /* 点击跳转到对应的界面 */
                switch (item.getItemId()) {
                    case R.id.nav_profile:
                        intent.setClass(BackgroundActivity.this, MainActivity.class);
                        break;
                    case R.id.nav_web:
                        intent.setClass(BackgroundActivity.this, WebActivity.class);
                        break;
                    case R.id.nav_photo:
                        intent.setClass(BackgroundActivity.this, PhotoActivity.class);
                        break;
                    case R.id.nav_upload:
                        intent.setClass(BackgroundActivity.this, UploadActivity.class);
                        break;
                    case R.id.nav_settings:
                        intent.setClass(BackgroundActivity.this, SettingsActivity.class);
                        break;
                }
                startActivity(intent);
                return true;
            }
        });
    }

    /**
     * @description: 获取组件
     */
    private void assignViews() {
        button_upload = findViewById(R.id.background_button_upload);
        button_web = findViewById(R.id.background_button_web);
        button_photo = findViewById(R.id.background_button_photo);
    }

    /**
     * @description: 设置点击事件-->对应不同的activity
     */
    private void initListener() {
        button_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(BackgroundActivity.this, UploadActivity.class);
                // 开始Activity
                startActivity(intent);
            }
        });
        button_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(BackgroundActivity.this, WebActivity.class);
                // 开始Activity
                startActivity(intent);
            }
        });
        button_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(BackgroundActivity.this, PhotoActivity.class);
                // 开始Activity
                startActivity(intent);
            }
        });
    }
}

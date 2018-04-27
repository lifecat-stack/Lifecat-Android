package com.example.a59682.myapplicationtest2018421;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author 59682
 * @name SettingsActivity
 * @description 用户设置界面
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        /* 设置bar左侧按钮 */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航按钮
//            actionBar.setHomeAsUpIndicator(R.mipmap.navigation);
        }
    }
}

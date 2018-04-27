package com.example.a59682.myapplicationtest2018421;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

/**
 * @author 59682
 * @name UploadActivity
 * @description 图片上传
 */
public class UploadActivity extends AppCompatActivity {

    private Button Browse;
    private ImageView Images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        /* 设置toolbar */
        Toolbar toolbar = findViewById(R.id.upload_toolbar);
        setSupportActionBar(toolbar);

        /* 设置bar左侧按钮 */
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航按钮
            //actionBar.setHomeAsUpIndicator(R.mipmap.navigation);
        }

        init();

        /* 点击打开UpLoadImage，使用Album进行上传 */
        Browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(UploadActivity.this, UploadImage.class);
                startActivity(intent);
            }
        });
    }

    /* 初始化 */
    private void init() {
        Browse = (Button) findViewById(R.id.browse);
        Images = (ImageView) findViewById(R.id.camera_image);
    }

    /* 选取并展示 ？ */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_OK) {
            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try {//压缩图片
                Bitmap mBitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * @description 设置menu点击事件
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /* 返回键 */
            case R.id.backup:
                Intent intent_backup = new Intent();
                intent_backup.setClass(UploadActivity.this, LoginActivity.class);
                startActivity(intent_backup);
                /* web键 */
            case R.id.web:
                Intent intent_web = new Intent();
                intent_web.setClass(UploadActivity.this, WebActivity.class);
                startActivity(intent_web);
                /* home键 */
            case R.id.home:
                Intent intent_home = new Intent();
                intent_home.setClass(UploadActivity.this, BackgroundActivity.class);
                startActivity(intent_home);
        }
        return true;
    }
}

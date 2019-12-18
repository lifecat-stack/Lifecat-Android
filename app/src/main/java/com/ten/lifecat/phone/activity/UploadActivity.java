package com.ten.lifecat.phone.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ten.lifecat.phone.R;
import com.ten.lifecat.phone.view.activity.BackgroundActivity;
import com.ten.lifecat.phone.view.activity.LoginActivity;
import com.ten.lifecat.phone.view.activity.WebActivity;
import com.yanzhenjie.album.Album;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Picture upload view
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
//            actionBar.setHomeAsUpIndicator(R.mipmap.navigation);
        }

        init();

        /* 点击打开UpLoadImage，使用Album进行上传 */
        Browse.setOnClickListener(view -> {
            Album.startAlbum(this, RESULT_OK
                    // 指定选择数量
                    , 9
                    // 指定Toolbar的颜色
                    , ContextCompat.getColor(this, R.color.colorPrimary)
                    // 指定状态栏的颜色
                    , ContextCompat.getColor(this, R.color.colorPrimaryDark));
        });
    }

    /* 初始化 */
    private void init() {
        Browse = findViewById(R.id.browse);
        Images = (ImageView) findViewById(R.id.camera_image);
    }

    /* 选取并展示 ？ */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        System.out.println("相册选择逻辑..................................");

        if (requestCode == RESULT_OK) {
            // 图片选择成功
            if (resultCode == RESULT_OK) {
                // 用户选择的图片路径List
                List<String> pathList = Album.parseResult(data);
                System.out.println("用户选择的图片路径: " + pathList);

                Uri uri = data.getData();
                ContentResolver cr = this.getContentResolver();
                try {
                    // 压缩图片
                    Bitmap mBitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));

                    Images.setImageBitmap(mBitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            // 用户取消选择
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "已取消图片选择", Toast.LENGTH_LONG).show();
                System.out.println("已取消图片选择");
            }
            // 图片选择失败
            else {
                Toast.makeText(this, "图片选择失败", Toast.LENGTH_LONG).show();
                System.out.println("图片选择失败");
            }
        } else {
            Toast.makeText(this, "图片选择请求码错误", Toast.LENGTH_LONG).show();
            System.out.println("图片选择请求码错误");
        }

        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == RESULT_OK) {
//            Uri uri = data.getData();
//            ContentResolver cr = this.getContentResolver();
//            try {
//                // 压缩图片
//                Bitmap mBitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 设置menu点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            /* 返回键 */
            case R.id.backup:
                Intent intentBackup = new Intent();
                intentBackup.setClass(UploadActivity.this, LoginActivity.class);
                startActivity(intentBackup);
                break;
            /* web键 */
            case R.id.web:
                Intent intent_web = new Intent();
                intent_web.setClass(UploadActivity.this, WebActivity.class);
                startActivity(intent_web);
                break;
            /* home键 */
            case R.id.home:
                Intent intent_home = new Intent();
                intent_home.setClass(UploadActivity.this, BackgroundActivity.class);
                startActivity(intent_home);
                break;
            default:
                break;
        }
        return true;
    }

}

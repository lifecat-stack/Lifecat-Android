package com.example.a59682.myapplicationtest2018421.activity;


import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a59682.myapplicationtest2018421.R;
import com.yanzhenjie.album.Album;

import java.util.List;

/**
 * @author 59682
 * @name UploadImage
 * @description 使用Album进行照片选取
 */
public class UploadImage extends AppCompatActivity {

    /**
     * @description 调用Album
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Album.startAlbum(this, RESULT_OK
                , 9                                                         // 指定选择数量。
                , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
                , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) { // 判断是否成功。
                // 拿到用户选择的图片路径List：
                List<String> pathList = Album.parseResult(data);
            } else if (resultCode == RESULT_CANCELED) { // 用户取消选择。
                // 根据需要提示用户取消了选择。
            }
        }
    }
}

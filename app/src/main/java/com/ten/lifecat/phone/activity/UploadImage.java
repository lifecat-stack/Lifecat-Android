package com.ten.lifecat.phone.activity;


import android.content.Intent;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ten.lifecat.phone.R;
import com.yanzhenjie.album.Album;

import java.util.List;

/**
 * 使用Album进行照片选取
 */
public class UploadImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Album.startAlbum(this, RESULT_OK
                // 指定选择数量
                , 9
                // 指定Toolbar的颜色
                , ContextCompat.getColor(this, R.color.colorPrimary)
                // 指定状态栏的颜色
                , ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

    /**
     * 回调 :用户相册操作结束
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_OK) {
            // 图片选择成功
            if (resultCode == RESULT_OK) {
                // 用户选择的图片路径List
                List<String> pathList = Album.parseResult(data);
                System.out.println("用户选择的图片路径: " + pathList);
            }
            // 用户取消选择
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "已取消图片选择", Toast.LENGTH_LONG).show();
            }
            // 图片选择失败
            else {
                Toast.makeText(this, "图片选择失败", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "图片选择请求码错误", Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}

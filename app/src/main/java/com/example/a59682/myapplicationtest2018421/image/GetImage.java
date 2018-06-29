package com.example.a59682.myapplicationtest2018421.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImage {

    //加载图片
//    public static Bitmap getUrlImage(String url) {
//
//        Bitmap img = null;
//
//        try {
//            URL picurl = new URL(url);
//            // 获得连接
//            HttpURLConnection conn = (HttpURLConnection) picurl.openConnection();
//            conn.setConnectTimeout(6000);//设置超时
//            conn.setDoInput(true);
//            conn.setUseCaches(false);//不缓存
//            conn.connect();
//            InputStream is = conn.getInputStream();//获得图片的数据流
//            img = BitmapFactory.decodeStream(is);
//            is.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return img;
//    }
}

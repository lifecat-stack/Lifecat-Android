package com.example.a59682.sharedpreferences;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
        // TODO: Return the communication channel to the service.
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService","onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }

    public class DownloadBinder extends Binder{

        public void startDownload(){
            Log.d("MyService","startDownload executed");
        }

        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }
}

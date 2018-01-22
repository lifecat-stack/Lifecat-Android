package com.example.a59682.sharedpreferences;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int UPDATE_TEXT = 1;

    private TextView change_text;
    private Button change_button;

    private Button start_button;
    private Button stop_button;
    private Button bind_button;
    private Button unbind_button;

    private MyService.DownloadBinder mDownloadBinder;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mDownloadBinder = (MyService.DownloadBinder) iBinder;
            mDownloadBinder.startDownload();
            mDownloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        change_text = (TextView) findViewById(R.id.textview);
        change_button = (Button) findViewById(R.id.change_button);
        bind_button= (Button) findViewById(R.id.bind_button);
        unbind_button= (Button) findViewById(R.id.unbind_button);

        start_button.setOnClickListener(this);
        stop_button.setOnClickListener(this);
        bind_button.setOnClickListener(this);
        unbind_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_button:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bind_button:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, mConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_button:
                Intent unbindIntent = new Intent(this, MyService.class);
                unbindService(mConnection);
            default:
                break;
        }
    }
}

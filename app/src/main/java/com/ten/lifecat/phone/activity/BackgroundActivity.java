package com.ten.lifecat.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageButton;

import com.ten.lifecat.phone.R;

/**
 * 主背景界面
 */
public class BackgroundActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private Button uploadIntentButton;
    private Button webIntentButton;
    private Button photoIntentButton;

    private ImageButton userIntentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        regisViews();

        // toolbar
        Toolbar toolbar = findViewById(R.id.background_toolbar);
        setSupportActionBar(toolbar);

        // navigation
        initNavigation();

        // listener
        buttonListener();
    }

    private void initNavigation() {
        NavigationView navigationView = findViewById(R.id.nav_view);

        // 导航按钮
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.navigation);
        }

        // 默认激活按钮
        navigationView.setCheckedItem(R.id.nav_profile);

        navigationView.setNavigationItemSelectedListener(item -> {
            Intent intent = new Intent();
            switch (item.getItemId()) {
                case R.id.nav_profile:
                    intent.setClass(BackgroundActivity.this, UserProfileActivity.class);
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
                default:
                    return false;
            }
            startActivity(intent);
            return true;
        });
    }

    private void regisViews() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        uploadIntentButton = findViewById(R.id.background_button_upload);
        webIntentButton = findViewById(R.id.background_button_web);
        photoIntentButton = findViewById(R.id.background_button_photo);
        userIntentButton = findViewById(R.id.background_button);
    }

    private void buttonListener() {
        uploadIntentButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(BackgroundActivity.this, UploadActivity.class);
            startActivity(intent);
        });

        webIntentButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(BackgroundActivity.this, WebActivity.class);
            startActivity(intent);
        });

        photoIntentButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(BackgroundActivity.this, PhotoActivity.class);
            startActivity(intent);
        });

        userIntentButton.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(BackgroundActivity.this, UserProfileActivity.class);
            startActivity(intent);
        });
    }
}

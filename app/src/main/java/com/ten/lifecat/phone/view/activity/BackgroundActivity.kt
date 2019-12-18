package com.ten.lifecat.phone.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.Button
import android.widget.ImageButton

import com.ten.lifecat.phone.R
import org.jetbrains.anko.startActivity

/**
 * 主背景界面
 */
class BackgroundActivity : AppCompatActivity() {

    private var mDrawerLayout: androidx.drawerlayout.widget.DrawerLayout? = null

    private var uploadIntentButton: Button? = null
    private var webIntentButton: Button? = null
    private var photoIntentButton: Button? = null

    private var userIntentButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)

        regisViews()

        // toolbar
        val toolbar = findViewById<Toolbar>(R.id.background_toolbar)
        setSupportActionBar(toolbar)

        // navigation
        initNavigation()

        // listener
        buttonListener()
    }

    private fun initNavigation() {
        val navigationView = findViewById<NavigationView>(R.id.nav_view)

        // 导航按钮
        val actionBar = supportActionBar
        actionBar?.let {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.mipmap.navigation)
        }

        // 默认激活按钮
        navigationView.setCheckedItem(R.id.nav_profile)
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> startActivity<UserProfileActivity>()
                R.id.nav_web -> startActivity<WebActivity>()
                R.id.nav_photo -> startActivity<PhotoActivity>()
                R.id.nav_upload -> startActivity<UploadActivity>()
                R.id.nav_settings -> startActivity<SettingsActivity>()
            }
            true
        }
    }

    private fun regisViews() {
        mDrawerLayout = findViewById(R.id.drawer_layout)
        uploadIntentButton = findViewById(R.id.background_button_upload)
        webIntentButton = findViewById(R.id.background_button_web)
        photoIntentButton = findViewById(R.id.background_button_photo)
        userIntentButton = findViewById(R.id.background_button)
    }

    private fun buttonListener() {
        uploadIntentButton!!.setOnClickListener { startActivity<UploadActivity>() }
        webIntentButton!!.setOnClickListener { startActivity<WebActivity>() }
        photoIntentButton!!.setOnClickListener { startActivity<PhotoActivity>() }
        userIntentButton!!.setOnClickListener { startActivity<UserProfileActivity>() }
    }
}

package com.ten.lifecat.phone.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.ImageButton

import com.ten.lifecat.phone.R

/**
 * 主背景界面
 */
class BackgroundActivity : AppCompatActivity() {

    private var mDrawerLayout: DrawerLayout? = null

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
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.mipmap.navigation)
        }

        // 默认激活按钮
        navigationView.setCheckedItem(R.id.nav_profile)

        navigationView.setNavigationItemSelectedListener { item ->
            val intent = Intent()
            when (item.itemId) {
                R.id.nav_profile -> intent.setClass(this@BackgroundActivity, UserProfileActivity::class.java)
                R.id.nav_web -> intent.setClass(this@BackgroundActivity, WebActivity::class.java)
                R.id.nav_photo -> intent.setClass(this@BackgroundActivity, PhotoActivity::class.java)
                R.id.nav_upload -> intent.setClass(this@BackgroundActivity, UploadActivity::class.java)
                R.id.nav_settings -> intent.setClass(this@BackgroundActivity, SettingsActivity::class.java)
                else -> println("no!")
            }
            startActivity(intent)
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
        uploadIntentButton!!.setOnClickListener { v ->
            val intent = Intent()
            intent.setClass(this@BackgroundActivity, UploadActivity::class.java)
            startActivity(intent)
        }

        webIntentButton!!.setOnClickListener { v ->
            val intent = Intent()
            intent.setClass(this@BackgroundActivity, WebActivity::class.java)
            startActivity(intent)
        }

        photoIntentButton!!.setOnClickListener { v ->
            val intent = Intent()
            intent.setClass(this@BackgroundActivity, PhotoActivity::class.java)
            startActivity(intent)
        }

        userIntentButton!!.setOnClickListener { v ->
            val intent = Intent()
            intent.setClass(this@BackgroundActivity, UserProfileActivity::class.java)
            startActivity(intent)
        }
    }
}

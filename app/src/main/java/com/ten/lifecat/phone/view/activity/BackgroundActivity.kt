package com.ten.lifecat.phone.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationView
import com.ten.lifecat.phone.R

/**
 * Background main view
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
                R.id.nav_profile -> startActivity(Intent(this, UserProfileActivity::class.java))
                R.id.nav_web -> startActivity(Intent(this, WebActivity::class.java))
                R.id.nav_photo -> startActivity(Intent(this, PhotoActivity::class.java))
                R.id.nav_upload -> startActivity(Intent(this, UploadActivity::class.java))
                R.id.nav_settings -> startActivity(Intent(this, SettingsActivity::class.java))
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
        uploadIntentButton!!.setOnClickListener { startActivity(Intent(this, UploadActivity::class.java)) }
        webIntentButton!!.setOnClickListener { startActivity(Intent(this, WebActivity::class.java)) }
        photoIntentButton!!.setOnClickListener { startActivity(Intent(this, PhotoActivity::class.java)) }
        userIntentButton!!.setOnClickListener { startActivity(Intent(this, UserProfileActivity::class.java)) }
    }
}

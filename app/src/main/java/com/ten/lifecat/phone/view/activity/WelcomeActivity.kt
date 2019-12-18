package com.ten.lifecat.phone.view.activity

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView

import com.ten.lifecat.phone.view.fragment.GuildFragment
import com.ten.lifecat.phone.R
import java.util.*

/**
 * 首次启动欢迎界面
 */
class WelcomeActivity : AppCompatActivity() {

    /**
     * 翻页视图容器
     */
    private var vp: ViewPager? = null
    /**
     * 欢迎动画 第一屏
     */
    private var iv1: ImageView? = null
    /**
     * 欢迎动画 第二屏
     */
    private var iv2: ImageView? = null
    /**
     * 欢迎动画 第三屏
     */
    private var iv3: ImageView? = null
    /**
     * 进入按钮 :进入登录注册界面
     */
    private var btStart: Button? = null

    /**
     * 欢迎动画集合
     */
    private var fragments: MutableList<Fragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 判断是否已经登录过
        val pref = getSharedPreferences("data", MODE_PRIVATE)!!
        val hasLogin = pref.getBoolean("hasLogin", false)

        // 首次登录 -> 继续 WelcomeActivity
        if (!hasLogin) {
            // 隐藏标题栏
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            // 隐藏状态栏
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

            setContentView(R.layout.activity_welcome)

            // 注册组件
            regisViews()
            // 注册按钮监听器
            regisButtionListener()
            // 注册动画
            regisAnimation()
            // 动画滑动效果
            slideAnimation()
        }
        // 已登录 -> 跳转到 BackgroundActivity
        else {
            startActivity(Intent(this@WelcomeActivity, LoginActivity::class.java))
            this.finish()
        }
    }


    /**
     * Register component
     */
    private fun regisViews() {
        vp = findViewById(R.id.vp)
        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)
        btStart = findViewById(R.id.bt_start)
    }

    /**
     * Jump to LoginActivity
     */
    private fun regisButtionListener() {
        btStart!!.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    /** Add Fragments to WelcomeActivity */
    private fun regisAnimation() {
        fragments = ArrayList()
        intArrayOf(1, 2, 3).forEach { n ->
            val fragment = GuildFragment()
            val bundle = Bundle()
            bundle.putInt("index", n)
            fragment.arguments = bundle
            fragments!!.add(fragment)
        }
    }

    /** 设置ViewPager的适配器和滑动监听 */
    private fun slideAnimation() {
        vp!!.offscreenPageLimit = 3
        vp!!.adapter = MyPageAdapter(supportFragmentManager)
        vp!!.addOnPageChangeListener(MyPageChangeListener())
    }

    /** ViewPage adapte */
    private inner class MyPageAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragments!![position]
        }

        override fun getCount(): Int {
            return fragments!!.size
        }
    }

    /**
     * ViewPager滑动页面监听器
     */
    private inner class MyPageChangeListener : ViewPager.OnPageChangeListener {

        /**
         * @param position 当前位置
         * @param positionOffset 位置偏移
         * @param positionOffsetPixels 位置偏移像素
         */
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        /**
         * 根据页面不同动态改变红点和在最后一页显示立即体验按钮
         */
        override fun onPageSelected(position: Int) {
            btStart!!.visibility = View.GONE
            iv1!!.setImageResource(R.mipmap.dot_normal)
            iv2!!.setImageResource(R.mipmap.dot_normal)
            iv3!!.setImageResource(R.mipmap.dot_normal)

            when (position) {
                0 -> iv1?.setImageResource(R.mipmap.dot_focus)
                1 -> iv2?.setImageResource(R.mipmap.dot_focus)
                2 -> {
                    iv3?.setImageResource(R.mipmap.dot_focus)
                    btStart!!.visibility = View.VISIBLE
                }
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}

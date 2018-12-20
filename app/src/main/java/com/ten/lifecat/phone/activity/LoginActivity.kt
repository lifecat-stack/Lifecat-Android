package com.ten.lifecat.phone.activity

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.ten.lifecat.phone.R
import com.ten.lifecat.phone.bean.User

/**
 * 用户登录注册界面
 */
class LoginActivity : AppCompatActivity() {

    /**
     * 登录邮箱
     */
    private var emailText: EditText? = null
    /**
     * 登录密码
     */
    private var passwordText: EditText? = null
    /**
     * 登录按钮
     */
    private var loginButton: Button? = null

    /**
     * 跳转到注册界面
     */
    private var signupLink: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_login)

        assignViews()
        initListener()
    }

    /**
     * @description 获取组件
     */
    private fun assignViews() {
        emailText = findViewById(R.id.input_email)
        passwordText = findViewById(R.id.input_password)
        loginButton = findViewById(R.id.btn_login)
        signupLink = findViewById(R.id.link_signup)
    }

    /**
     * @description button点击事件
     */
    private fun initListener() {
        /* 登录button */
        loginButton!!.setOnClickListener { v -> login() }
        /* 注册button */
        signupLink!!.setOnClickListener { v ->
            // Start the Signup activity
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivityForResult(intent, REQUEST_SIGNUP)
            finish()
        }
    }

    /**
     * @description 登录button事件
     */
    fun login() {
        Log.d(TAG, "Login")

        /* 表单验证-->若失败，直接return */
        if (!validate()) {
            onLoginFailed()
            return
        }

        /* 锁定登录按钮直至验证完成 */
        loginButton!!.isEnabled = false

        /* 验证时:弹出框 */
        val progressDialog = ProgressDialog(this@LoginActivity,
                R.style.AppTheme_Dark_Dialog)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Authenticating...")
        progressDialog.show()

        /* 获取用户登录信息 */
        val email = emailText!!.text.toString()
        val password = passwordText!!.text.toString()

        // TODO: Implement your own authentication logic here.
        /*------ 验证逻辑 ------*/

        /* 认证成功 */
        if (User.validateUser(email, password)) {
            /* 启动成功线程-->延时三秒动画 */
            android.os.Handler().postDelayed(
                    {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess()
                        progressDialog.dismiss()
                    }, 1000)
        } else {
            /* 启动失败线程-->延时三秒动画 */
            android.os.Handler().postDelayed(
                    {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginFailed()
                        progressDialog.dismiss()
                    }, 1000)
        }/* 认证失败 */
    }

    /*---------- Activity方法 ----------*/

    /**
     * @description 登录成功-->UserProfileActivity
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == Activity.RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                /*------ 登录成功 ------*/
                val intent = Intent()
                intent.setClass(this@LoginActivity, BackgroundActivity::class.java)
                startActivity(intent)

                this.finish()
            }
        }
    }

    /**
     * @description 返回键
     */
    override fun onBackPressed() {
        // Disable going back to the WelcomeActivity
        moveTaskToBack(true)
    }

    /**
     * @description 登录成功-->跳转 + finish Activity
     */
    fun onLoginSuccess() {
        loginButton!!.isEnabled = true

        // 邮箱密码存储到本地数据库，设置登录标记为true
        val editor = getSharedPreferences("data", MODE_PRIVATE)!!.edit()
        editor.putString("user_email", emailText!!.text.toString())
        editor.putString("user_password", passwordText!!.text.toString())
        editor.putBoolean("hasLogin", true)
        editor.apply()

        /* 跳转到BackgroundActivity */
        val intent = Intent()
        intent.setClass(this@LoginActivity, BackgroundActivity::class.java)
        startActivity(intent)

        /* 关闭LoginActivity */
        finish()
    }

    /**
     * @description 登录失败-->广播
     */
    fun onLoginFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
        loginButton!!.isEnabled = true
    }

    /**
     * @return 表单合格-->true  表单不合格-->false
     * @description 表单验证
     */
    fun validate(): Boolean {
        var valid = true

        val email = emailText!!.text.toString()
        val password = passwordText!!.text.toString()
        /* email=null 或 email不符合格式 */
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText!!.error = "enter a valid email address"
            valid = false
        } else {
            emailText!!.error = null
        }
        /* password==null 或 password小于4字符 或 password大于10字符 */
        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            passwordText!!.error = "between 4 and 10 alphanumeric characters"
            valid = false
        } else {
            passwordText!!.error = null
        }

        return valid
    }

    companion object {

        /* 广播信息 */
        private val TAG = "LoginActivity"
        private val REQUEST_SIGNUP = 0
    }
}

package com.ten.lifecat.phone.view.activity

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

/**
 * @name: SignupActivity
 * @description: 注册界面
 * @author: 59682
 */
class SignupActivity : AppCompatActivity() {
    /* 组件ID */
    private var _nameText: EditText? = null
    private var _emailText: EditText? = null
    private var _passwordText: EditText? = null
    private var _signupButton: Button? = null
    private var _loginLink: TextView? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* 隐藏标题栏 */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_signup)

        assignViews()
        initListener()
    }

    /**
     * @description: 获取组件
     */
    private fun assignViews() {
        _nameText = findViewById(R.id.input_name)
        _emailText = findViewById(R.id.input_email)
        _passwordText = findViewById(R.id.input_password)
        _signupButton = findViewById(R.id.btn_signup)
        _loginLink = findViewById(R.id.link_login)
    }

    /**
     * @description: button点击事件
     */
    private fun initListener() {
        /* 注册按钮 */
        _signupButton!!.setOnClickListener { signup() }
        /* 登录链接按钮 */
        _loginLink!!.setOnClickListener {
            // Finish the registration screen and return to the Login activity
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    /**
     * @description 注册
     */
    fun signup() {
        Log.d(TAG, "Signup")

        /* 验证表单格式 */
        if (!validate()) {
            onSignupFailed()
            return
        }

        _signupButton!!.isEnabled = false

        val progressDialog = ProgressDialog(this@SignupActivity,
                R.style.AppTheme_Dark_Dialog)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Creating Account...")
        progressDialog.show()

        val name = _nameText!!.text.toString()
        val email = _emailText!!.text.toString()
        val password = _passwordText!!.text.toString()

        // TODO: Implement your own signup logic here.

        android.os.Handler().postDelayed(
                {
                    // On complete call either onSignupSuccess or onSignupFailed
                    // depending on success
                    onSignupSuccess()
                    // onSignupFailed();
                    progressDialog.dismiss()
                }, 1000)
    }

    /**
     * @description 注册成功-->跳转到MainActivity
     */
    fun onSignupSuccess() {
        _signupButton!!.isEnabled = true
        setResult(Activity.RESULT_OK, null)

        /* 跳转 */
        val intent = Intent()
        intent.setClass(this@SignupActivity, BackgroundActivity::class.java)
        startActivity(intent)

        /* 销毁当前Activity */
        finish()
    }

    /**
     * @description 注册失败
     */
    fun onSignupFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
        _signupButton!!.isEnabled = true
    }

    /**
     * @description 表单格式验证
     */
    fun validate(): Boolean {
        var valid = true

        val name = _nameText!!.text.toString()
        val email = _emailText!!.text.toString()
        val password = _passwordText!!.text.toString()

        /* name */
        if (name.isEmpty() || name.length < 3) {
            _nameText!!.error = "at least 3 characters"
            valid = false
        } else {
            _nameText!!.error = null
        }

        /* email */
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText!!.error = "enter a valid email address"
            valid = false
        } else {
            _emailText!!.error = null
        }

        /* password */
        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            _passwordText!!.error = "between 4 and 10 alphanumeric characters"
            valid = false
        } else {
            _passwordText!!.error = null
        }

        return valid
    }

    companion object {
        /* 广播信息 */
        private val TAG = "SignupActivity"
    }
}
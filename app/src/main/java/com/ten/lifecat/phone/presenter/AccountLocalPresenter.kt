package com.ten.lifecat.phone.presenter

import android.content.Context
import com.ten.lifecat.phone.util.preference.Preference

/**
 * 用户账号的本地存储Presenter，通过委托访问SharePreference数据库
 */
class AccountLocalPresenter(val context: Context) {
    var hasLogin: Boolean by Preference(context, "has_login", false)
    var userEmail: String by Preference(context, "user_email", "")
    var userPassword: String by Preference(context, "user_password", "")
}

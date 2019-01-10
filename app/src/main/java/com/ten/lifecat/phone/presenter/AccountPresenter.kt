package com.ten.lifecat.phone.presenter

import android.content.Context
import com.ten.lifecat.phone.util.Preference

class AccountPresenter(val context: Context) {
    var hasLogin: Boolean by Preference(context, "has_login", false)
    var userEmail: String by Preference(context, "user_email", "")
    var userPassword: String by Preference(context, "user_password", "")
}

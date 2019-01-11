package com.ten.lifecat.phone.presenter

import java.util.HashMap

/**
 * 用户账号的远程Presenter，通过HTTP访问远程服务，进行账号校验
 */
object AccountRemotePresenter {

    private var USER: HashMap<String, String>? = null
    private var EMAIL: Array<String>? = null
    private var PASSWORD: Array<String>? = null

    /**
     * 设置默认密码库
     */
    init {
        USER = HashMap()
        EMAIL = arrayOf("wsh@qq.com", "admin@gmail.com", "wangshihao@gmail.com", "zhuzhenyu@gmail.com", "ouyangchun@gmail.com", "chenjiahui@gmail.com", "lijuhang@gmail.com")
        PASSWORD = arrayOf("wang", "123456", "123456", "123456", "123456", "123456", "123456")
        for (i in EMAIL!!.indices) {
            USER!![EMAIL!![i]] = PASSWORD!![i]
        }
    }

    /**
     * 验证邮箱和密码
     */
    fun validateUser(email: String, password: String): Boolean {
        return containEmail(email) && isPasswordValid(email, password)
    }

    /**
     * 检查是否包含用户账号
     */
    private fun containEmail(email: String): Boolean {
        return USER!!.containsKey(email)
    }

    /**
     * 检查密码是否正确
     */
    private fun isPasswordValid(email: String, password: String): Boolean {
        return USER!![email] == password
    }
}

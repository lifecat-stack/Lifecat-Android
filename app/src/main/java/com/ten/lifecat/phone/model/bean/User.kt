package com.ten.lifecat.phone.model.bean

import java.util.HashMap

/**
 * @author 59682
 * @name User
 * @description 用户账号默认数据库
 */
object User {

    private var USER: HashMap<String, String>? = null
    private var EMAIL: Array<String>? = null
    private var PASSWORD: Array<String>? = null

    /* 设置默认密码库 */
    init {
        USER = HashMap()
        EMAIL = arrayOf("wsh@qq.com", "admin@gmail.com", "wangshihao@gmail.com", "zhuzhenyu@gmail.com", "ouyangchun@gmail.com", "chenjiahui@gmail.com", "lijuhang@gmail.com")
        PASSWORD = arrayOf("wang", "123456", "123456", "123456", "123456", "123456", "123456")
        for (i in EMAIL!!.indices) {
            USER!![EMAIL!![i]] = PASSWORD!![i]
        }
    }

    /**
     * @description 验证账号和密码
     */
    fun validateUser(email: String, password: String): Boolean {
        return if (containEmail(email) && containPassword(email, password)) {
            true
        } else {
            false
        }
    }

    /* 检查是否包含用户账号 */
    private fun containEmail(email: String): Boolean {
        return if (USER!!.containsKey(email)) {
            true
        } else {
            false
        }
    }

    /* 检查密码是否正确 */
    private fun containPassword(email: String, password: String): Boolean {
        return if (USER!![email] == password) {
            true
        } else {
            false
        }
    }
}

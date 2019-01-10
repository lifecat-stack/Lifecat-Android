package com.ten.lifecat.phone.util.http

/**
 * @description 子线程的回调接口
 */
interface HttpCallbackListener {
    fun onFinish(response: String)
    fun onError(e: Exception)
}

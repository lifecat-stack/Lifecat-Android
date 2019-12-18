package com.ten.lifecat.phone.util.http

/**
 * 子线程的回调接口
 */
interface HttpCallbackListener {
    fun onFinish(response: String) = print("default finish func")
    fun onError(e: Exception) = print("default error func")
}

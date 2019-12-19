package com.ten.lifecat.phone.view.fragment

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.View
import android.widget.VideoView

/**
 * @author 59682
 * @name CustomVideoView
 * @description 播放视频的VIEW
 */
class CustomVideoView : VideoView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec))
    }

    /**
     * 播放视频
     *
     * @param uri 播放地址
     */
    fun playVideo(uri: Uri?) {
        if (uri == null) {
            throw IllegalArgumentException("Uri can not be null")
        }
        /**设置播放路径 */
        setVideoURI(uri)
        /**开始播放 */
        start()
        setOnPreparedListener { mp ->
            /**设置循环播放 */
            /**设置循环播放 */
            mp.isLooping = true
        }
        setOnErrorListener { mp, what, extra -> true }
    }
}

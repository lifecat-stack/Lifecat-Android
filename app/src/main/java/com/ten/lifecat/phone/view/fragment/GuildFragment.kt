package com.ten.lifecat.phone.view.fragment

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ten.lifecat.phone.R

/**
 * @author 59682
 * @name GuildFragment
 * @description 管理VIEW的适配器
 */
class GuildFragment : Fragment() {

    private var customVideoView: CustomVideoView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        customVideoView = context?.let { CustomVideoView(it) }
        /**获取参数，根据不同的参数播放不同的视频 */
        val index = arguments!!.getInt("index")
        val uri: Uri
        if (index == 1) {
            uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + R.raw.guide_1)
        } else if (index == 2) {
            uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + R.raw.guide_2)
        } else {
            uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + R.raw.guide_3)
        }
        /**播放视频 */
        customVideoView!!.playVideo(uri)
        return customVideoView
    }

    /**
     * 记得在销毁的时候让播放的视频终止
     */
    override fun onDestroyView() {
        super.onDestroyView()
        if (customVideoView != null) {
            customVideoView!!.stopPlayback()
        }
    }
}

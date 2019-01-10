package com.ten.lifecat.phone.view.fragment.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.ten.lifecat.phone.model.bean.Msg
import com.ten.lifecat.phone.R

/**
 * Created by 59682 on 2017/10/7.
 */

class MsgAdapter(private val mMsgList: List<Msg>) : RecyclerView.Adapter<MsgAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var leftLayout: LinearLayout
        var rightLayout: LinearLayout
        var leftMsg: TextView
        var rightMsg: TextView

        init {
            leftLayout = view.findViewById<View>(R.id.left_layout) as LinearLayout
            rightLayout = view.findViewById<View>(R.id.right_layout) as LinearLayout
            leftMsg = view.findViewById<View>(R.id.left_msg) as TextView
            rightMsg = view.findViewById<View>(R.id.right_msg) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (content, type) = mMsgList[position]
        if (type == Msg.TYPE_RECEIVED) {
            holder.leftLayout.visibility = View.VISIBLE
            holder.rightLayout.visibility = View.GONE
            holder.leftMsg.text = content
        } else if (type == Msg.TYPE_SENT) {
            holder.rightLayout.visibility = View.VISIBLE
            holder.leftLayout.visibility = View.GONE
            holder.rightMsg.text = content
        }
    }

    override fun getItemCount(): Int {
        return mMsgList.size
    }
}

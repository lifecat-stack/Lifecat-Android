package com.ten.lifecat.phone.view.adapter

import android.content.Context
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.ten.lifecat.phone.model.bean.Photo
import com.ten.lifecat.phone.R

/**
 * 图片卡片适配器 adapter for recyclerView
 */
class PhotoAdapter(private val mPhotoList: List<Photo>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private var mContext: Context? = null

    /**
     * 嵌套缓存类，直接从Holder中取item 无需findid重新加载
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /* view点击事件 */
        var cardView: CardView = itemView as CardView
        var photoImage: ImageView = itemView.findViewById(R.id.photo_image)
        var photoName: TextView = itemView.findViewById(R.id.photo_name)
    }

    /**
     * 生成Holder实例
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mContext == null) {
            mContext = parent.context
        }
        val view = LayoutInflater.from(mContext).inflate(R.layout.photo_item, parent, false)
        return ViewHolder(view)
    }

    /**
     * 滚动到屏幕内时执行
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = mPhotoList[position]

        holder.photoName.text = photo.name

        /* 使用Glide加载图片 */
        Glide.with(mContext!!).load(photo.imageId).into(holder.photoImage)
    }

    /**
     * 返回item总的项数
     */
    override fun getItemCount(): Int {
        return mPhotoList.size
    }
}

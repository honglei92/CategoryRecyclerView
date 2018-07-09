package com.whlei.categoryrecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.whlei.categoryrecyclerview.R
import com.whlei.categoryrecyclerview.bean.Level2Category

/**
 * @author:honglei92
 * @time:2018/7/9
 */
class Level2Adapter(var context: Context, var categories: ArrayList<Level2Category>) : Adapter<RecyclerView.ViewHolder>() {
    val TYPE_TITLE = 0
    val TYPE_CONTENT = 1
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        if (p1 == TYPE_TITLE) {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_level2_category_title, p0, false))
        } else {
            return ViewHolderLevel2Content(LayoutInflater.from(context).inflate(R.layout.item_level2_category_content, p0, false))
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun getItemViewType(position: Int): Int {
        var level2Category: Level2Category = categories[position]
        if (level2Category.isTitle) {
            return TYPE_TITLE
        } else {
            return TYPE_CONTENT
        }
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (getItemViewType(p1) == TYPE_TITLE) {
            var mViewHolder: ViewHolder = p0 as ViewHolder
            mViewHolder.mTextView.text = categories[p1].categoryName
        } else {
            var mViewHolderLevel2Content: ViewHolderLevel2Content = p0 as ViewHolderLevel2Content
            mViewHolderLevel2Content.mTextView.text = categories[p1].categoryName
            mViewHolderLevel2Content.mImageView.setBackgroundResource(categories[p1].imgSrc!!)
        }


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTextView: TextView = itemView.findViewById(R.id.level2Name)
    }

    class ViewHolderLevel2Content(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTextView: TextView = itemView.findViewById(R.id.level2Name)
        var mImageView: ImageView = itemView.findViewById(R.id.level2Image)
    }
}
package com.whlei.categoryrecyclerview.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.whlei.categoryrecyclerview.R
import com.whlei.categoryrecyclerview.bean.Level1Category

/**
 * @author:honglei92
 * @time:2018/7/9
 */
class Level1Adapter(var context: Context, var categories: ArrayList<Level1Category>) : Adapter<Level1Adapter.ViewHolder>() {
    lateinit var mOnItemClickListener: OnItemClickListener
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_level1_category, p0, false))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.mTextView.text = categories[p1].categoryName
        if (categories[p1].isSelected) {
            p0.mTextView.setTextColor(Color.parseColor("#3DBE59"))
            p0.mTextView.setBackgroundResource(R.drawable.levelback)
        } else {
            p0.mTextView.setTextColor(Color.parseColor("#666666"))
            p0.mTextView.setBackgroundColor(Color.parseColor("#F3F3F4"))
        }
        p0.mTextView.setOnClickListener {
            for (i in categories.indices) {
                if (categories[i].isSelected) {
                    categories[i].isSelected = false
                }
            }
            categories[p0.layoutPosition].isSelected = true
            mOnItemClickListener.onItemClick(it, p1)
            notifyDataSetChanged()
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTextView: TextView = itemView.findViewById(R.id.level1Name)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

}
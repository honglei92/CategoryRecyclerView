package com.whlei.categoryrecyclerview.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.whlei.categoryrecyclerview.R
import com.whlei.categoryrecyclerview.adapter.Level1Adapter
import com.whlei.categoryrecyclerview.adapter.Level2Adapter
import com.whlei.categoryrecyclerview.bean.Level1Category
import com.whlei.categoryrecyclerview.bean.Level2Category
import com.whlei.categoryrecyclerview.constants.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mLevel1Adapter: Level1Adapter
    lateinit var mLevel2Adapter: Level2Adapter
    lateinit var mGirdLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initLevel1RecyclerView()
        initLevel2RecyclerView(Constants.mLevel1Categories[0])
    }


    private fun initLevel1RecyclerView() {
        var mCategoryList = ArrayList<Level1Category>()
        for (i in Constants.mLevel1Categories.indices) {
            var category = Level1Category(Constants.mLevel1Categories[i], false)
            mCategoryList.add(category)
        }
        level1RecyclerView.layoutManager = object : LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false) {}
        level1RecyclerView.itemAnimator = DefaultItemAnimator()
        mLevel1Adapter = Level1Adapter(this@MainActivity, mCategoryList)
        mLevel1Adapter.setOnItemClickListener(object : Level1Adapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                initLevel2RecyclerView(mCategoryList[position].categoryName)
            }

        })
        level1RecyclerView.adapter = mLevel1Adapter

    }

    private fun initLevel2RecyclerView(level1CategoryName: String) {
        var mCategory2List = ArrayList<Level2Category>()
        initCategory2List(level1CategoryName, mCategory2List)


        mGirdLayoutManager = object : GridLayoutManager(this@MainActivity, 3, GridLayoutManager.VERTICAL, false) {}
        /**
         * title项占一行单元格
         */
        mGirdLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(p0: Int): Int {
                return if (mCategory2List[p0].isTitle) 3 else 1
            }
        }
        level2RecyclerView.layoutManager = mGirdLayoutManager
        level2RecyclerView.itemAnimator = DefaultItemAnimator()
        mLevel2Adapter = Level2Adapter(this@MainActivity, mCategory2List)
        level2RecyclerView.adapter = mLevel2Adapter
    }

    private fun initCategory2List(level1CategoryName: String, mCategory2List: ArrayList<Level2Category>) {
        for (i in Constants.getLevel2Category(level1CategoryName).indices) {
            var level2Category = Level2Category(Constants.getLevel2Category(level1CategoryName)[i], true)
            mCategory2List.add(level2Category)
            for (j in Constants.getLevel2CategoryContent(Constants.getLevel2Category(level1CategoryName)[i]).indices) {
                var category = Level2Category(Constants.getLevel2CategoryContent(Constants.getLevel2Category(level1CategoryName)[i])[j], false)
                category.isSelected = false
                category.imgSrc = R.mipmap.ic_launcher
                mCategory2List.add(category)
            }
        }

    }

}

package com.whlei.categoryrecyclerview.bean

/**
 * @author:honglei92
 * @time:2018/7/9
 */
class Level2Category(s: String, b: Boolean) {
    var categoryName: String
    var isTitle: Boolean = false
    var imgSrc: Int? = null

    var isSelected: Boolean = false

    init {
        this.categoryName = s
        this.isTitle = b
    }

}


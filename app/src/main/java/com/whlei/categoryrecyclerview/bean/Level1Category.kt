package com.whlei.categoryrecyclerview.bean

/**
 * @author:honglei92
 * @time:2018/7/9
 */
class Level1Category(s: String, b: Boolean) {
    var categoryName: String
    var isSelected: Boolean = false

    init {
        this.categoryName = s
        this.isSelected = b
    }

}
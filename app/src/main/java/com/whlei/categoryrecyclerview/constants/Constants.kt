package com.whlei.categoryrecyclerview.constants

/**
 * @author:honglei92
 * @time:2018/7/9
 */
class Constants {
    companion object {
        val mLevel1Categories = arrayOf("水果蔬菜", "肉禽蛋奶", "冷热素食", "休闲食品", "酒水饮料", "粮油调味",
                "清洁日化", "家居用品", "鲜花蛋糕", "医药健康")

        fun getLevel2Category(level1CategoryName: String): Array<String> {
            when (level1CategoryName) {
                "水果蔬菜" -> {
                    return mLevel2CategoriesA
                }
                "肉禽蛋奶" -> {
                    return mLevel2CategoriesB
                }
                "冷热素食" -> {
                    return mLevel2CategoriesC
                }
            }
            return mLevel2CategoriesA
        }

        fun getLevel2CategoryContent(level2CategoryTitle: String): Array<String> {
            when (level2CategoryTitle) {
                "水果" -> {
                    return mLevel2CategoriesFruit
                }
                "蔬菜" -> {
                    return mLevel2CategoriesVegetables
                }
                "牛羊猪禽" -> {
                    return mLevel2CategoriesMeat
                }
                "水产海鲜" -> {
                    return mLevel2CategoriesWater
                }
                "蛋类" -> {
                    return mLevel2CategoriesEgg
                }
                "奶制品" -> {
                    return mLevel2CategoriesMilk
                }
                "进口乳制品" -> {
                    return mLevel2CategoriesImportMilk
                }
                "低温素食" -> {
                    return mLevel2CategoriesLowTempretrue
                }
                "常温素食" -> {
                    return mLevel2CategoriesHigetempreture
                }
            }
            return mLevel2CategoriesFruit
        }

        val mLevel2CategoriesA = arrayOf("水果", "蔬菜")
        val mLevel2CategoriesB = arrayOf("牛羊猪禽", "水产海鲜", "蛋类", "奶制品", "进口乳制品")
        val mLevel2CategoriesC = arrayOf("低温素食", "常温素食")

        val mLevel2CategoriesFruit = arrayOf("苹果", "梨", "瓜类", "猕猴桃", "柑桔柚", "更多水果")
        val mLevel2CategoriesVegetables = arrayOf("根茎类", "叶菜类", "瓜果类", "骨菌类", "调味类", "半成品净菜")
        val mLevel2CategoriesMeat = arrayOf("牛肉", "羊肉", "猪肉", "内脏", "禽类")
        val mLevel2CategoriesWater = arrayOf("鱼", "虾蟹贝类", "其他水产")
        val mLevel2CategoriesEgg = arrayOf("鸡蛋", "鸭蛋", "其他蛋类")
        val mLevel2CategoriesMilk = arrayOf("牛奶", "酸奶", "奶酪类")
        val mLevel2CategoriesImportMilk = arrayOf("进口牛奶", "进口酸奶", "其他乳制品")
        val mLevel2CategoriesLowTempretrue = arrayOf("虾饺", "牛丸", "香豆腐")
        val mLevel2CategoriesHigetempreture = arrayOf("八宝粥", "火腿肠", "方便面")
    }
}
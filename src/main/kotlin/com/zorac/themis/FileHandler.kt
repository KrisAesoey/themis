package com.zorac.themis

class FileHandler {
    companion object {

        fun loadListFromTxt(filePath: String): List<String> {
            val inputStream = object {}.javaClass.classLoader.getResourceAsStream(filePath)
            return inputStream!!.bufferedReader().use { it.readLines() }
        }

        fun createRankingListFromTxt(filePath: String): List<RankingItem> {
            val inputStream = object {}.javaClass.classLoader.getResourceAsStream(filePath)
            val items = inputStream!!.bufferedReader().use { it.readLines() }
            return createRankingList(items)
        }

        fun createRankingListFromJSON() {
        }
        fun createRankingList(items: List<String>): List<RankingItem> {
            return items.map { RankingItem.createNewItem(it, 100) }
        }
    }
}
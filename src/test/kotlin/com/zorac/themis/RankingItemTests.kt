package com.zorac.themis;

import org.junit.jupiter.api.Test;

class RankingItemTests {

    @Test
    fun rankingItemsSortedByScoreTest() {
        val higherScoreItem = RankingItem.createNewItem("a", 2)
        val lowerScoreItem = RankingItem.createNewItem("b", 1)
        val wronglySortedItemList = listOf(lowerScoreItem, higherScoreItem)
        val sortedItemList = wronglySortedItemList.sorted()
        assert(sortedItemList[0] == higherScoreItem)
        assert(sortedItemList[1] == lowerScoreItem)
    }
}

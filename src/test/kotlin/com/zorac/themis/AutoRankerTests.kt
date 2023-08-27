package com.zorac.themis

import org.junit.jupiter.api.Test

class AutoRankerTests {

    companion object {
        val goldenRanking = listOf("a", "b", "c", "d", "e", "f")
        val rankingItems = goldenRanking.map { RankingItem.createNewItem(it, 0) }
        val autoRanker = AutoRanker(goldenRanking)
    }

    @Test
    fun lengthOfMatchupResultIsEqualToMatchupTest() {
        for (matchupItems in 1 .. goldenRanking.size) {
            val matchup = rankingItems.slice(0 until matchupItems)
            val matchupResult = autoRanker.getMatchupResult(matchup)
            assert(matchup.size == matchupResult.size)
        }
    }

    @Test
    fun itemOfHigherGoldenRankingIsFirstInMatchupResultTest() {
        val higherRankedItem = rankingItems[2]
        val lowerRankedItem = rankingItems[5]
        val matchupResult = autoRanker.getMatchupResult(listOf(lowerRankedItem, higherRankedItem))
        assert(matchupResult[0] == higherRankedItem)
        assert(matchupResult[1] == lowerRankedItem)
    }

}
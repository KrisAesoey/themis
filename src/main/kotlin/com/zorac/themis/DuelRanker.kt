package com.zorac.themis

import kotlin.math.abs

class DuelRanker(override var rankingItems: List<RankingItem>) : Ranker {

    var rounds = 0
    var totalMatches = 0
    private var roundMatchups = mutableListOf<List<RankingItem>>()

    /**
     * Generates rounds in a Swiss style format,
     * where the moment an item has been sorted out
     * it's removed from the comparisons
     */
    private fun generateRound() {
        rounds += 1
        val eligebleItems = rankingItems.sorted().filter {
           abs(it.wins - it.losses) < rankingItems.size / 2 - 1
        }
        val selectedItems = mutableSetOf<RankingItem>()
        roundMatchups.clear()
        for ((i, firstItem) in eligebleItems.withIndex()) {
            for ((j, secondItem) in eligebleItems.withIndex()) {
                if (i == j) continue
                if (firstItem in selectedItems || secondItem in selectedItems) continue
                roundMatchups.add(listOf(firstItem, secondItem))
                selectedItems.add(firstItem)
                selectedItems.add(secondItem)
            }
        }
        roundMatchups.shuffle()
    }

    override fun getMatch(): List<RankingItem> {
        if (roundMatchups.isEmpty()) {
            generateRound()
        }
        if (roundMatchups.isEmpty()) return emptyList()
        totalMatches += 1
        return roundMatchups.removeAt(0)
    }

    override fun setMatchResult(matchResult: List<RankingItem>) {
        val winner = matchResult[0]
        val loser = matchResult[1]
        winner.wins += 1
        loser.losses += 1
        winner.updateScore(1)
        loser.updateScore(-1)
    }

    override fun getResult(): List<RankingItem> {
        return rankingItems.sorted()
    }

}
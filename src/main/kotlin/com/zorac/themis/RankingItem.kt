package com.zorac.themis

data class RankingItem(val id: Int, val name: String, var score: Int): Comparable<RankingItem> {

    var wins = 0
    var losses = 0

    companion object {
        private var lastAssignedId = -1

        fun createNewItem(name: String, score: Int): RankingItem {
            lastAssignedId++
            return RankingItem(lastAssignedId, name, score)
        }
    }

    var previousMatchUps = mutableSetOf<RankingItem>()

    fun addMatchup(opponent: RankingItem) {
        previousMatchUps.add(opponent)
    }

    fun getPreviousMatchups(): Set<RankingItem> { return previousMatchUps }

    fun updateScore(points: Int) {
        score += points
    }

    override fun compareTo(other: RankingItem): Int {
        return other.score - this.score
    }

}
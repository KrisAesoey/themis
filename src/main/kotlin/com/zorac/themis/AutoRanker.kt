package com.zorac.themis

/**
 * A class that automatically performs the ranking process
 * for a matchup, based on an internal ranking of the items
 * to be ranked. A tool to speed up testing by avoiding the
 * need for interactive ranking.
 */
class AutoRanker(private val goldenRanking: List<String>) {
    fun getMatchupResult(matchup: List<RankingItem>): List<RankingItem> {
        return matchup.sortedBy { goldenRanking.indexOf(it.name) }
    }
}
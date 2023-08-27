package com.zorac.themis

/**
 * Interface to define what any ranking method
 * has to incorporate
 */
interface Ranker {

    var rankingItems: List<RankingItem>
    fun getMatch(): List<RankingItem>

    fun setMatchResult(matchResult: List<RankingItem>)

    fun getResult(): List<RankingItem>
}
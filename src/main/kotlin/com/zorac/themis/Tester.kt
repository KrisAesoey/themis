package com.zorac.themis;

fun main() {

    val goldenList = FileHandler.loadListFromTxt("datasets/berries8.txt")
    val autoRanker = AutoRanker(goldenList)
    val rankingItems = goldenList.map { RankingItem.createNewItem(it, 0) }
    val duelRanker = DuelRanker(rankingItems)

    while (true) {
        if (duelRanker.rounds > 10) break
        val matchup = duelRanker.getMatch()
        if (matchup.isEmpty()) break
        val matchupResult = autoRanker.getMatchupResult(matchup)
        duelRanker.setMatchResult(matchupResult)
    }

    for ((item, golden) in duelRanker.getResult().zip(goldenList)) {
        println("$item $golden")
    }

    print("Total rounds: ${duelRanker.rounds} and total matchups: ${duelRanker.totalMatches}")
}
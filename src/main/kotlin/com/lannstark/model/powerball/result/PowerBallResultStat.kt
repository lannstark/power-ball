package com.lannstark.model.powerball.result

import com.lannstark.model.powerball.PowerBallRank

data class PowerBallResultStat constructor(
  private val results: Map<PowerBallRank, Int>,
  private val firstRewardDividend: Long,
) {

  fun getDividend(): Long {
    return dividendOfFirst() + this.results.map { (rank, size) -> rank.reward * size }.sum()
  }

  private fun dividendOfFirst(): Long {
    return if (results.contains(PowerBallRank.FIRST)) {
      firstRewardDividend
    } else {
      0L
    }
  }

  override fun toString(): String {
    return toStringOfFirst() + results.filter { (key, _) -> key != PowerBallRank.FIRST }
      .map { (rank, size) -> "- ${rank.displayName} ${size}개 당첨 (${rank.reward * size}$ 수익)" }
      .joinToString("\n")
  }

  private fun toStringOfFirst(): String {
    return if (results.contains(PowerBallRank.FIRST)) {
      "- ${PowerBallRank.FIRST.displayName} ${results[PowerBallRank.FIRST]}개 당첨 (${this.firstRewardDividend}$ 수익)\n"
    } else {
      ""
    }
  }

}
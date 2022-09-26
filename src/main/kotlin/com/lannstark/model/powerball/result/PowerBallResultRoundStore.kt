package com.lannstark.model.powerball.result

import com.lannstark.model.powerball.PowerBall

data class PowerBallResultRoundStore constructor(
  private val stat: PowerBallResultStat,
  private val buyingPowerBallCount: Int,
) {

  val inputAmount: Long
    get() = this.buyingPowerBallCount * PowerBall.PRICE

  val dividend: Long
    get() = this.stat.getDividend()

  override fun toString(): String {
    return "- ${buyingPowerBallCount}개 구매 (${inputAmount}\$ 지출)" + this.stat
  }

}
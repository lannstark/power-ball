package com.lannstark.dto.powerball.result

import kotlin.math.roundToInt

data class PowerBallSettleDto(
  private val accumulatedInputAmount: Long,
  private val accumulatedDividend: Long,
) {

  private val secondDecimalPlaceRatio: Double
    get() = (this.ratio * 100).roundToInt() / 100.0

  private val ratio: Double
    get() = (accumulatedDividend - accumulatedInputAmount) / accumulatedInputAmount.toDouble() * 100

  override fun toString(): String {
    return "누적 손익정산 : ${accumulatedInputAmount} 지출 / ${accumulatedDividend} 수익 / 수익률 ${secondDecimalPlaceRatio}%"
  }

}
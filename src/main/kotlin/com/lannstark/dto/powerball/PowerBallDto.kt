package com.lannstark.dto.powerball

import com.lannstark.model.powerball.PowerBall

class PowerBallDto(
  private val mainNumbers: List<Int>,
  private val subNumber: Int,
) {

  override fun toString(): String {
    return mainNumbers.joinToString("") { number -> "${number} " } + subNumber
  }

  companion object {
    fun of(powerBall: PowerBall): PowerBallDto {
      return PowerBallDto(
        mainNumbers = powerBall.mainNumbers,
        subNumber = powerBall.subNumber
      )
    }
  }
}
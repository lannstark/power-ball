package com.lannstark.model.powerball

/**
 * PowerBall 의 배당표
 * main count와 sub count의 개수를 이용해
 */
enum class PowerBallRank(
  private val mainCount: Int,
  private val isMatchSubNumber: Boolean,
  // 단위 : $
  val reward: Long,
  val displayName: String,
) {

  /**
   * FIRST는 예외적으로 처리해주게 된다.
   */
  FIRST(5, true, 0, "1등"),
  SECOND(5, false, 1_000_000, "2등"),
  THIRD(4, true, 50_000, "3등"),
  FOURTH(4, false, 100, "4등"),
  FIFTH(3, true, 100, "5등"),
  SIXTH(3, false, 7, "6등"),
  SEVENTH(2, true, 7, "7등"),
  EIGHTH(1, true, 4, "8등"),
  NINTH(0, true, 4, "9등"),

  NONE(0, false, 0, "꽝")
  ;

  private fun isMatch(mainCount: Int, isMatchSubNumber: Boolean): Boolean {
    return this.mainCount == mainCount && this.isMatchSubNumber == isMatchSubNumber
  }

  companion object {
    fun of(targetPowerBall: PowerBall, answer: PowerBall): PowerBallRank {
      return of(targetPowerBall.matchMainNumber(answer), targetPowerBall.isMatchSubNumber(answer))
    }

    private fun of(mainCount: Int, isMatchSubNumber: Boolean): PowerBallRank {
      return values().firstOrNull { rank -> rank.isMatch(mainCount, isMatchSubNumber) }
        ?: NONE
    }
  }
}
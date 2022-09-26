package com.lannstark.model.powerball

/**
 * 사용자가 구매한 PowerBall 1장
 * 미국 로또(?) PowerBall은 메인 숫자 5개와 서브 숫자 1개로 구성되어 있다.
 */
class PowerBall(
  val mainNumbers: List<Int>,
  val subNumber: Int,
) {

  init {
    require(mainNumbers.size == MAIN_NUMBER_SIZE) {
      "PowerBall은 ${MAIN_NUMBER_SIZE}개의 메인 숫자가 필요합니다. 현재: ${mainNumbers.size}"
    }

    require(mainNumbers.size == mainNumbers.toSet().size) {
      "중복된 숫자가 들어올 수 없습니다. ${mainNumbers}"
    }
  }

  fun matchMainNumber(answer: PowerBall): Int {
    return this.mainNumbers.count { it in answer.mainNumbers }
  }

  fun isMatchSubNumber(answer: PowerBall): Boolean {
    return this.subNumber == answer.subNumber
  }

  companion object {
    const val MAIN_NUMBER_SIZE = 5
    const val PRICE: Long = 2 // 단위 : $

    fun fixture(vararg numbers: Int): PowerBall {
      return PowerBall(numbers.toList().subList(0, 5), numbers.last())
    }
  }

}
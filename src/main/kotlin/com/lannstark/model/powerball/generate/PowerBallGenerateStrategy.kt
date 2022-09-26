package com.lannstark.model.powerball.generate

/**
 * PowerBall의 main 숫자 5개와 sub 숫자 1개를 고르는 전략 객체
 */
abstract class PowerBallGenerateStrategy(
  protected open val data: PowerBallGenerateData,
) {

  abstract fun pickMainNumbers(mainNumbers: List<Int>): List<Int>

  abstract fun pickSubNumbers(subNumbers: List<Int>): Int

}

class AutoPowerBallGenerateStrategy : PowerBallGenerateStrategy(PowerBallGenerateNullData()) {
  override fun pickMainNumbers(mainNumbers: List<Int>): List<Int> {
    return mainNumbers.shuffled().subList(0, 5)
  }

  override fun pickSubNumbers(subNumbers: List<Int>): Int {
    return subNumbers.shuffled().first()
  }
}

class ManualPowerBallGenerateStrategy(
  override val data: PowerBallGenerateManualData
) : PowerBallGenerateStrategy(data) {
  override fun pickMainNumbers(mainNumbers: List<Int>): List<Int> {
    return data.numbers.subList(0, 5)
  }

  override fun pickSubNumbers(subNumbers: List<Int>): Int {
    return data.numbers.last()
  }

  companion object {
    fun testFixture(vararg numbers: Int): ManualPowerBallGenerateStrategy {
      return ManualPowerBallGenerateStrategy(PowerBallGenerateManualData(numbers.toList()))
    }
  }
}

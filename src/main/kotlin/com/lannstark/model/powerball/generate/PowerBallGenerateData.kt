package com.lannstark.model.powerball.generate

/**
 * 추후 여러 전략 객체가 필요할 때 사용되는 DTO
 */
sealed class PowerBallGenerateData

/**
 * 수동 생성 전략에 사용되는 DTO
 */
data class PowerBallGenerateManualData(
  val numbers: List<Int>
) : PowerBallGenerateData() {
  init {
    require(numbers.size == 6)
  }
}

/**
 * default parameter에 사용하기 위한 DTO
 */
class PowerBallGenerateNullData : PowerBallGenerateData()
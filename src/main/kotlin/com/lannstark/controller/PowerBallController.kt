package com.lannstark.controller

import com.lannstark.dto.powerball.PowerBallDto
import com.lannstark.model.powerball.PowerBall
import com.lannstark.model.powerball.generate.AutoPowerBallGenerateStrategy
import com.lannstark.model.powerball.generate.PowerBallGenerateStrategy
import com.lannstark.model.powerball.generate.PowerBallGenerator
import com.lannstark.model.powerball.result.PowerBallResultStore
import com.lannstark.view.*

class PowerBallController(
  private val generator: PowerBallGenerator = PowerBallGenerator(),
  private val autoStrategy: PowerBallGenerateStrategy = AutoPowerBallGenerateStrategy(),
  private val resultStore: PowerBallResultStore = PowerBallResultStore(),
) {

  fun start() {
    while (true) {
      val autoPowerBall = inputAutoPowerBall()
      if (autoPowerBall == 0) {
        return
      }

      val powerBalls = buyPowerBallsAndPrint(autoPowerBall)
      val answer = selectAnswerAndPrint(resultStore.currentRound)
      finishRoundAndPrint(powerBalls, answer)
    }
  }

  private fun finishRoundAndPrint(
    powerBalls: List<PowerBall>,
    answer: PowerBall
  ) {
    val round = resultStore.finishRound(powerBalls, answer)
    printRoundResult(round)
    printSettlement(resultStore.toSettleDto())
  }

  private fun buyPowerBallsAndPrint(count: Int): List<PowerBall> {
    val powerBalls = (1..count).map { generator.issue(autoStrategy) }
    printBuyingPowerBalls(powerBalls.map { PowerBallDto.of(it) })
    return powerBalls
  }

  private fun selectAnswerAndPrint(round: Int): PowerBall {
    val answer = generator.issue(autoStrategy)
    printAnswerPowerBall(PowerBallDto.of(answer), round)
    return answer
  }

}
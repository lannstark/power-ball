package com.lannstark.model.powerball.generate

import com.lannstark.model.powerball.PowerBall

class PowerBallGenerator {

  private val mainNumberPool: List<Int> = (1..69).toList()
  private val subNumberPool: List<Int> = (1..26).toList()

  fun issue(strategy: PowerBallGenerateStrategy): PowerBall {
    return PowerBall(
      mainNumbers = strategy.pickMainNumbers(mainNumberPool),
      subNumber = strategy.pickSubNumbers(subNumberPool)
    )
  }

}
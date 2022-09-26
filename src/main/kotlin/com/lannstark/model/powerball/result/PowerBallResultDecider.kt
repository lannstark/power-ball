package com.lannstark.model.powerball.result

import com.lannstark.model.powerball.PowerBall
import com.lannstark.model.powerball.PowerBallRank

class PowerBallResultDecider {

  fun decidePowerBallResults(
    powerBalls: List<PowerBall>,
    answer: PowerBall,
    firstRewardDividend: Long,
  ): PowerBallResultStat {
    return powerBalls.map { powerBall -> PowerBallRank.of(powerBall, answer) }
      .groupBy { it }
      .mapValues { (_, ranks) -> ranks.size }
      .toSortedMap()
      .let { PowerBallResultStat(it, firstRewardDividend) }
  }

}
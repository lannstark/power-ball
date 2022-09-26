package com.lannstark.model.powerball.result

import com.lannstark.dto.powerball.result.PowerBallSettleDto
import com.lannstark.model.powerball.PowerBall

class PowerBallResultStore {

  private val rounds: MutableList<PowerBallResultRoundStore> = mutableListOf()
  private val decider: PowerBallResultDecider = PowerBallResultDecider()

  val currentRound: Int
    get() = this.rounds.size + 1

  fun finishRound(powerBalls: List<PowerBall>, answer: PowerBall): PowerBallResultRoundStore {
    val stat = decider.decidePowerBallResults(powerBalls, answer, accumulatedRemainAmount)
    return PowerBallResultRoundStore(stat, powerBalls.size).apply { rounds.add(this) }
  }

  private val accumulatedInputAmount: Long
    get() = this.rounds.sumOf { round -> round.inputAmount }

  private val accumulatedDividend: Long
    get() = this.rounds.sumOf { round -> round.dividend }

  private val accumulatedRemainAmount: Long
    get() = this.accumulatedInputAmount - this.accumulatedDividend

  fun toSettleDto(): PowerBallSettleDto {
    return PowerBallSettleDto(
      accumulatedInputAmount = accumulatedInputAmount,
      accumulatedDividend = accumulatedDividend
    )
  }
}
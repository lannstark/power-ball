package com.lannstark.model.powerball.result

import com.lannstark.model.powerball.PowerBall
import com.lannstark.model.powerball.PowerBallRank
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

internal class PowerBallResultDeciderTest {

  @Test
  fun `파워볼 당첨 결과를 알아낸다`() {
    // given
    val powerBalls = listOf(
      PowerBall.fixture(1, 2, 3, 4, 5, 7), // 2등
      PowerBall.fixture(6, 7, 8, 9, 10, 8), // 당첨X
      PowerBall.fixture(1, 2, 3, 4, 5, 7), // 2등
      PowerBall.fixture(1, 2, 3, 4, 5, 6), // 1등
    )
    val answer = PowerBall.fixture(1, 2, 3, 4, 5, 6)
    val decider = PowerBallResultDecider()

    // when
    val stat = decider.decidePowerBallResults(powerBalls, answer)

    // then
    assertThat(stat).isEqualTo(
      PowerBallResultStat(
        mapOf(
          PowerBallRank.FIRST to 1,
          PowerBallRank.SECOND to 2,
          PowerBallRank.NONE to 1,
        )
      )
    )
  }

}
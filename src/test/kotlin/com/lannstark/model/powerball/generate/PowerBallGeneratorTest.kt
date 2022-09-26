package com.lannstark.model.powerball.generate

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

internal class PowerBallGeneratorTest {

  @Test
  fun `파워볼 생성 테스트`() {
    // given
    val generator = PowerBallGenerator()
    val strategy = ManualPowerBallGenerateStrategy.testFixture(1, 2, 3, 4, 5, 6)

    // when
    val result = generator.issue(strategy)

    // then
    assertThat(result.mainNumbers).isEqualTo(listOf(1, 2, 3, 4, 5))
    assertThat(result.subNumber).isEqualTo(6)
  }

}
package com.lannstark.view

import com.lannstark.dto.powerball.PowerBallDto
import com.lannstark.dto.powerball.result.PowerBallSettleDto
import com.lannstark.model.powerball.result.PowerBallResultRoundStore

fun printBuyingPowerBalls(dtos: List<PowerBallDto>) {
  println()
  println("구매된 파워볼 번호")
  dtos.forEach { dto -> println(dto) }
}

fun printAnswerPowerBall(dto: PowerBallDto, round: Int) {
  println()
  println("${round}회차 당첨 파워볼 번호")
  println(dto)
}

fun printRoundResult(round: PowerBallResultRoundStore) {
  println()
  println("회차정산")
  println(round)
}

fun printSettlement(settleDto: PowerBallSettleDto) {
  println(settleDto)
  println()
  println()
}
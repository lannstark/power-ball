package com.lannstark.view

fun inputAutoPowerBall(): Int {
  print("구매할 파워볼 개수를 입력해주세요 : ")
  return readLine()?.toInt()
    ?: throw IllegalArgumentException("우선 예외")
}
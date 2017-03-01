package com.combatpong.logic.model

object Config {

  val width: Int = 1440
  val height: Int = 2560
  val batWidth: Int = 144
  val batHeight: Int = 28
  val ballRadius: Int = 14
  val padding: Int = 28
  val initialBatVelocity = Velocity(10, 10)
  val batDimensions = Rect(batWidth, batHeight)

  val initialP1 = {
    val position = Position((width - batWidth) / 2, height - batHeight - padding)
    Bat(position, batDimensions, Velocity.ZERO)
  }

  val initialP2 = {
    val position = Position((width - batWidth) / 2, padding)
    Bat(position, batDimensions, Velocity.ZERO)
  }

  val initialBall = {
    val position = Position(width / 2 - ballRadius, height / 2 - ballRadius)
    Ball(position, ballRadius, initialBatVelocity)
  }

  val initialBounds = Rect(width, height)
}

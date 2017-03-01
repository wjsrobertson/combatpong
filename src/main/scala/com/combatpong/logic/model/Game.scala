package com.combatpong.logic.model

case class Game(bounds: Rect, bat1: Bat, bat2: Bat, ball: Ball) {

  lazy val inverseView: Game = {
    val inverseBall = ball.copy(position = invert(ball.position), velocity = invert(ball.velocity))

    copy(bat1 = invert(bat1), bat2 = invert(bat2), ball = inverseBall)
  }

  private def invert(bat: Bat): Bat = bat.copy(position = invert(bat.position, -Config.padding), velocity = invert(bat.velocity))

  private def invert(velocity: Velocity): Velocity = Velocity(-velocity.x, -velocity.y)

  private def invert(position: Position, yAdjust: Int = 0): Position = Position(
    (bounds.width - position.x).abs,
    (bounds.height - position.y).abs + yAdjust
  )
}

object Game {
  def apply: Game = Game(Config.initialBounds, Config.initialP1, Config.initialP2, Config.initialBall)
}

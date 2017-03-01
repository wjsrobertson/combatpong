package com.combatpong.logic.model

import com.combatpong.UnitSpec

class GameTest extends UnitSpec {

  val testGame = Game(
    Rect(100, 200),
    Bat(Position(10, 10), Rect(20, 5), Velocity(5, 20)),
    Bat(Position(80, 185), Rect(20, 5), Velocity(-10, -15)),
    Ball(Position(30, 80), 5, Velocity(11, 22))
  )

  "A Game" should "have an inverse which has the ball in the opposite corner" in {
    val inverse = testGame.inverseView

    inverse.ball.position.x shouldBe 70d +- 0.01
  }

}

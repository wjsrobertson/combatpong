package com.combatpong.logic.model

case class Velocity(x: Double, y: Double)

object Velocity {
  val ZERO = apply(0, 0)
}
package com.example

import com.combatpong.messages.PingRequest

object Hello {
  def main(args: Array[String]): Unit = {
    PingRequest(1)
    println("Hello, world!")
  }
}

package com.combatpong.sessions

// TODO revisit use of mutability here
class GameStartLoop(pendingPlayerQueue: PendingPlayerQueue, gameStarter: GameStarter) {

  var running = true

  val thread = new Thread(
    new Runnable {
      override def run() = {
        while (running) {
          try {
            val downstreamPlayerPair = pendingPlayerQueue.nextPair
            gameStarter.startGameAndNotifyPlayers(downstreamPlayerPair)
          } catch {
            case _: Throwable =>
          }
        }
      }
    }
  )

  def start(): Unit = thread.start()

  def stop(): Unit = {
    running = false
    thread.interrupt()
  }
}

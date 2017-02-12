package com.combatpong.sessions

import java.util.concurrent.Executors.newSingleThreadScheduledExecutor
import java.util.concurrent.TimeUnit

import com.google.common.util.concurrent.ThreadFactoryBuilder

// TODO - consider AKKA or something here
class GameUpdateLoop (val gameRepository: GameSessionRepository, val gameUpdater: GameUpdater){

  private val PAUSE_BETWEEN_UPDATES_MS = 30L

  private val service = newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setNameFormat("game update thread ").build)

  def startScheduledGameUpdates() {
    service.scheduleAtFixedRate(
      new Runnable {
        override def run() = gameRepository.getAll.foreach(gameUpdater.updateGameAndNotifyPlayers)
      }, 0L, PAUSE_BETWEEN_UPDATES_MS, TimeUnit.MILLISECONDS
    )
  }

  def stop = {
    service.shutdownNow()
    service.awaitTermination(10, TimeUnit.SECONDS)
  }
}

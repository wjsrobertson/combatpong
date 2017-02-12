package com.combatpong.sessions

import com.combatpong.logic.{GameFactory, GameRepository}
import com.combatpong.messaging.PlayerNotifier
import com.combatpong.translation.GameToGameStartMessage

class GameStarter(gameFactory: GameFactory,
                  gameSessionRepository: GameSessionRepository,
                  gameRepository: GameRepository,
                  gameToGameStartMessage: GameToGameStartMessage,
                  playerNotifier: PlayerNotifier) {

  def startGameAndNotifyPlayers(players: DownstreamPlayerPair): Unit = {
    val gameSession = GameSession("", players)
    val game = gameFactory.createGame()

    val messages = gameToGameStartMessage.translateGameToGameStart(game)

    playerNotifier.notifyGameStarted(gameSession.players.player1.session, messages._1)
    playerNotifier.notifyGameStarted(gameSession.players.player2.session, messages._2)

    gameSessionRepository.add(gameSession)
    gameRepository.add(gameSession, game)
  }
}

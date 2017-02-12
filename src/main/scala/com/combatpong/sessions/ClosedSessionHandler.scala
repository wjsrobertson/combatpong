package com.combatpong.sessions

import javax.websocket.Session

import com.combatpong.logic.GameRepository
import com.combatpong.messaging.PlayerNotifier

class ClosedSessionHandler(pendingPlayerQueue: PendingPlayerQueue,
                           gameSessionRepository: GameSessionRepository,
                           gameAbortPlayerNotifier: PlayerNotifier,
                           gameRepository: GameRepository) {

  def handleClosedSession(session: Session) {
    removePlayerFromGameQueueIfPresent(session)
    endLiveGameIfInProgress(session)
  }

  def removePlayerFromGameQueueIfPresent(session: Session) = pendingPlayerQueue.removeBySessionId(session.getId)

  def endLiveGameIfInProgress(session: Session) = {
    gameSessionRepository.findBySessionId(session.getId).foreach(g => {
      gameSessionRepository.remove(g)
      gameRepository.remove(g)

      Seq(g.players.player1, g.players.player2)
        .map(_.session)
        .filter(_.isOpen)
        .foreach(gameAbortPlayerNotifier.notifyGameAborted)
    })
  }
}

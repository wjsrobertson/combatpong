package com.combatpong.sessions

import java.util.concurrent.CopyOnWriteArraySet

import scala.collection.JavaConverters._

class GameSessionRepository {

  private val gameSessions = new CopyOnWriteArraySet[GameSession].asScala

  def add(gameSession: GameSession) = gameSessions += gameSession

  def remove(gameSession: GameSession) = gameSessions -= gameSession

  def findBySessionId(sessionId: String): Option[GameSession] = gameSessions.find(g => {
    g.players.player1.session.getId == sessionId || g.players.player2.session.getId == sessionId
  })

  def getAll = gameSessions.toSet
}
gameRepository
package com.combatpong.logic

import java.util.concurrent.ConcurrentHashMap

import com.combatpong.logic.model.Game
import com.combatpong.sessions.GameSession
import scala.collection.JavaConverters._

class GameRepository {

  val games = new ConcurrentHashMap[GameSession,Game]().asScala

  def add(session: GameSession, game: Game) = games(session) = game

  def get(session: GameSession): Option[Game] = games.get(session)

  def remove(session: GameSession) = games.remove(session)

}

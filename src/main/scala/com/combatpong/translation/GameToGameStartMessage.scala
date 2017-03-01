package com.combatpong.translation

import com.combatpong.logic.model.{Bat, Game}
import com.combatpong.messages.com.combatpong.messages.GameStart
import com.combatpong.messages.com.combatpong.messages

class GameToGameStartMessage {

  def translateGameToGameStart(game: Game): (GameStart, GameStart) = ???

  private def bat(bat: Bat): (messages.Position, messages.Rect) = {
    val pos = messages.Position(bat.position.x.toInt, bat.position.y.toInt)
    val rect = messages.Rect(bat.dimensions.width, bat.dimensions.height)

    (pos, rect)
  }
}

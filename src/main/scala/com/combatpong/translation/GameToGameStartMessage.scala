package com.combatpong.translation

import com.combatpong.logic.model.Game
import com.combatpong.messages.com.combatpong.messages.GameStart

class GameToGameStartMessage {

  def translateGameToGameStart(game: Game): (GameStart, GameStart) = ???

}

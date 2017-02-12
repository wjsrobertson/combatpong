package com.combatpong.messaging

import javax.websocket.Session

import com.combatpong.messages.com.combatpong.messages.{GameEnd, GameStart, ServerMessage}
import com.combatpong.messages.com.combatpong.messages.ServerMessage.Payload.{GameEnd => GameEndPayload, GameStart => GameStartPayload}

class PlayerNotifier(messageSender: MessageSender) {

  def notifyGameAborted(session: Session): Unit = {
    val payload = GameEndPayload(GameEnd(won = true, GameEnd.Reason.CONNECTION_LOST))
    val message = ServerMessage(ServerMessage.Type.GAME_END, payload)
    messageSender.sendAsync(session, message)
  }

  def notifyGameStarted(session: Session, gameStart: GameStart): Unit = {
    val payload = GameStartPayload(gameStart)
    val message = ServerMessage(ServerMessage.Type.GAME_START, payload)
    messageSender.sendAsync(session, message)
  }
}

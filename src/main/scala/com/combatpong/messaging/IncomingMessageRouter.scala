package com.combatpong.messaging

import javax.websocket.Session

import com.combatpong.messages.com.combatpong.messages.ClientMessage

class IncomingMessageRouter(pingRequestMessageProcessor: PingRequestMessageProcessor,
                            userRegistrationMessageProcessor: UserRegistrationMessageProcessor,
                            gameStartRequestMessageProcessor: GameStartRequestMessageProcessor) {

  def route(messageBytes: Array[Byte], session: Session) = {
    val message = ClientMessage.parseFrom(messageBytes)

    message.messageType match {
      case ClientMessage.Type.PING_REQUEST => message.getPingRequest
      case ClientMessage.Type.USER_REGISTRATION => message.getUserRegistration
      case ClientMessage.Type.GAME_START_REQUEST => message.getGameStartRequest
      case ClientMessage.Type.USER_ACTION => message.getUserAction
    }
  }
}

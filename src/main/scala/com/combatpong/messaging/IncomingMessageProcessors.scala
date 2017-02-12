package com.combatpong.messaging

import javax.websocket.Session

import com.combatpong.messages.com.combatpong.messages.ServerMessage
import com.combatpong.messages.com.combatpong.messages._
import com.combatpong.messages.com.combatpong.messages.ServerMessage.Payload.{PingResponse => PingResponsePayload}
import com.combatpong.sessions.{DownstreamPlayer, PendingPlayerQueue}

class PingRequestMessageProcessor(messageSender: MessageSender) {
  def process(pingRequest: PingRequest, session: Session) = {
    val payload = PingResponsePayload(PingResponse(pingRequest.challenge))
    val message = ServerMessage(ServerMessage.Type.PING_RESPONSE, payload)

    messageSender.sendAsync(session, message)
  }
}

class UserRegistrationMessageProcessor(messageSender: MessageSender, pendingPlayerQueue: PendingPlayerQueue) {
  def process(userRegistration: UserRegistration, session: Session) = {
    val downstreamPlayer = DownstreamPlayer(session.getId, userRegistration.name, session)
    pendingPlayerQueue.add(downstreamPlayer)
  }
}

// TODO split user registration an and game start using a separate session ID => name repository
class GameStartRequestMessageProcessor(messageSender: MessageSender) {
  def process(gameStartRequest: GameStartRequest, session: Session) = {

  }
}

class UserActionMessageProcessor() {
  def process(userAction: UserAction, session: Session) = {

  }
}

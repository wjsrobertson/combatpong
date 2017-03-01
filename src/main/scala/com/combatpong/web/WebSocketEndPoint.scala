package com.combatpong.web

import javax.websocket._
import javax.websocket.server.ServerEndpoint
import java.io.IOException

import com.combatpong.messaging.IncomingMessageRouter
import com.combatpong.sessions.ClosedSessionHandler

@ServerEndpoint(value = "/websocket")
class WebSocketEndPoint(messageRouter: IncomingMessageRouter, closedSessionHandler: ClosedSessionHandler) {

  @OnMessage
  @throws[IOException]
  @throws[InterruptedException]
  def onMessage(message: Array[Byte], session: Session) {
    messageRouter.route(message, session)
  }

  @OnClose
  def onClose(session: Session) {
    closedSessionHandler.handleClosedSession(session)
  }
}

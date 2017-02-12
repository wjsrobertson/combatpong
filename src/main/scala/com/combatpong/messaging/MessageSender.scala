package com.combatpong.messaging

import java.nio.ByteBuffer
import javax.websocket.Session

import com.trueaccord.scalapb.GeneratedMessage

class MessageSender {

  def sendAsync(session: Session, message: GeneratedMessage): Unit = {
    val messageByteBuffer = ByteBuffer.wrap(message.toByteArray)
    session.getAsyncRemote.sendBinary(messageByteBuffer)
  }

  def send(session: Session, message: GeneratedMessage): Unit = {
    val messageByteBuffer = ByteBuffer.wrap(message.toByteArray)
    session.getBasicRemote.sendBinary(messageByteBuffer)
  }
}

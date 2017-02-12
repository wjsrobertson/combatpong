package com.combatpong.sessions

import java.util.concurrent.{ArrayBlockingQueue, BlockingQueue}
import java.util.function.Predicate

import com.combatpong.messages.com.combatpong.messages.UserRegistration

import scala.collection._

// TODO - reconsider mutability in nextPair
// TODO - get the implicit Predicate conversion working for queue.removeIf
class PendingPlayerQueue(val queue: BlockingQueue[DownstreamPlayer] = new ArrayBlockingQueue[DownstreamPlayer](128, true)) {

  /*
  implicit def toJavaPredicate[A](f: A => Boolean): Predicate[A] = new Predicate[A] {
    override def test(a: A): Boolean = f(a)
  }
  */

  def add(player: DownstreamPlayer) = queue.add(player)

  def size = queue.size()

  def removeBySessionId(sessionId: String) = queue.removeIf(new Predicate[DownstreamPlayer] {
    override def test(p: DownstreamPlayer) = p.session.getId == sessionId
  })

  def nextPair: DownstreamPlayerPair = {
    val pair = mutable.HashSet[DownstreamPlayer]()
    while (pair.size < 2) {
      pair += queue.take()
      pair.retain(_.session.isOpen)
    }

    DownstreamPlayerPair(pair.take(1).head, pair.take(1).head)
  }
}

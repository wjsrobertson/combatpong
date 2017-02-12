package com.combatpong.sessions

import javax.websocket.Session

case class DownstreamPlayer(userId: String, name: String, session: Session)

case class DownstreamPlayerPair(player1: DownstreamPlayer, player2: DownstreamPlayer)

case class GameSession(gameId: String, players: DownstreamPlayerPair)

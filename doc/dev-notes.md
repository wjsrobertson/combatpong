# Development Notes

## Tech

* Protocol Buffers
* Websockets
* Scala
* ScalaTest
* ScalaMock
* Play Framework
* ES6
* NPM

## Messages

###ClientMessage

* PingRequest
* UserRegistration
* GameStartRequest
* UserAction

###ServerMessage

* PingResponse
* UserRegistrationAcceptance
* GameInit
* TimerUpdate
* GameStart
* GameUpdate - Position, Rect
* LevelEnd
* LevelInit
* GameEnd

## State

###Client states:

                                                                        />-----> GameEnding ----> GameOver
                                                                        |                            |
    PageLoaded -> ServerConnected -> UserRegistered -> GameInitialised -> InPLay -> LevelPending     |
                        ^                                               |                |           |
                        |                                                ----------------</          |
                        |                                                                            |
                        ----------------------------------------------------------------------------</


## Project import

*Intellij* - add `target/scala-2.11/src_managed` to module sources if Intellij doesn't pick it up itself
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
* GameUpdate
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


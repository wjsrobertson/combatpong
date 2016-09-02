import java.nio.file.Paths
import com.trueaccord.scalapb.{ScalaPbPlugin => PB}
import sbt.Keys._

name := """combatpong"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.3"
libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value

PB.protobufSettings
PB.runProtoc in PB.protobufConfig := (args => com.github.os72.protocjar.Protoc.runProtoc("-v261" +: args.toArray))
//scalaSource in PB.protobufConfig := sourceManaged.value
scalaSource in PB.protobufConfig := Paths.get(sourceManaged.value.getAbsolutePath + "/main").toFile
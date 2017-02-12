import java.nio.file.Paths
import com.trueaccord.scalapb.{ScalaPbPlugin => PB}
import sbt.Keys._

name := """combatpong"""

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.4"
libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value
libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"
libraryDependencies += "javax" % "javaee-api" % "7.0" % "provided"
//libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty"
libraryDependencies += "com.google.guava" % "guava" % "19.0"

PB.protobufSettings
PB.runProtoc in PB.protobufConfig := (args => com.github.os72.protocjar.Protoc.runProtoc("-v261" +: args.toArray))
//scalaSource in PB.protobufConfig := sourceManaged.value
scalaSource in PB.protobufConfig := Paths.get(sourceManaged.value.getAbsolutePath + "/main").toFile
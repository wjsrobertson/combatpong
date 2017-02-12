addSbtPlugin("com.trueaccord.scalapb" % "sbt-scalapb" % "0.4.20")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")
addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "2.3.1")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

libraryDependencies ++= Seq(
  "com.github.os72" % "protoc-jar" % "3.0.0-b2.1"
)
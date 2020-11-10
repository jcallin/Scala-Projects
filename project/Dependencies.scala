import sbt._

object Dependencies {
  val akkaVersion = "2.6.10"

  val akkaDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor"   % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  )
}

import sbt._

object Dependencies {
  val commonDependencies = Seq(
    "org.apache.commons"          % "commons-lang3"      % "3.11",
    "org.scalactic"              %% "scalactic"          % "3.0.8",
    "org.scala-lang.modules"     %% "scala-java8-compat" % "0.9.0",
    "com.typesafe"                % "config"             % "1.4.1",
    "com.typesafe.scala-logging" %% "scala-logging"      % "3.9.2",
    "org.typelevel"              %% "cats-core"          % "2.0.0"
  )
  val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % "3.0.8",
    "org.scalamock" %% "scalamock" % "4.3.0"
  )

  val akkaVersion = "2.6.10"

  val akkaDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor"   % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  )

  val scalikeJdbcDependencies = Seq(
    "org.scalikejdbc" %% "scalikejdbc"        % "3.5.0",
    "org.scalikejdbc" %% "scalikejdbc-config" % "3.5.0",
    "com.h2database"   % "h2"                 % "1.4.200",
    "org.postgresql"   % "postgresql"         % "42.2.18",
    "ch.qos.logback"   % "logback-classic"    % "1.2.3"
  )
}

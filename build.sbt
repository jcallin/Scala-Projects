name := "Scala-projects"

version in ThisBuild := "1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.13.0-M1"

scalacOptions in ThisBuild += "-deprecation"

val commonDependencies = Seq(
  "org.scalactic" %% "scalactic" % "3.0.3",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"
)

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.3",
  "org.scalamock" %% "scalamock" % "4.0.0"
)

lazy val root = (project in file("."))
  .aggregate(tools, algorithms, dataStructures)
  .settings(Settings.commonSettings)

lazy val dataStructures = Project(
  base = file("data-structures"),
  id = "data-structures",
)
  .dependsOn(tools)
  .settings(Seq(
    Keys.name := "data-structures",
    Keys.description := "Implementations of common data structures",
    Keys.libraryDependencies := commonDependencies
  ) ++ Settings.commonSettings)

lazy val algorithms = Project(
  base = file("algorithms"),
  id = "algorithms",
)
  .dependsOn(tools)
  .settings(Seq(
    Keys.name := "algorithms",
    Keys.description := "Implementations of algorithms",
    Keys.libraryDependencies := commonDependencies
  ) ++ Settings.commonSettings)

lazy val tools = Project(
  base = file("tools"),
  id = "tools"
)
  .settings(Seq(
    Keys.name := "tools",
    Keys.description := "Tools to share between projects",
    Keys.libraryDependencies := testDependencies
  ) ++ Settings.commonSettings)

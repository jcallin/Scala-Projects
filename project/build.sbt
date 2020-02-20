import sbt.Keys._
import sbt._

lazy val testSettings = Seq(
  testOptions in Test ++= Seq(
    Tests.Argument(
      TestFrameworks.ScalaTest,
      "-oF",
      "-h",
      "target/scalatest-report"
    )
  )
)

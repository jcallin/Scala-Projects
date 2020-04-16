import sbt.{Command, TaskKey}
import sbt.Keys._

object Settings {
  import scoverage.ScoverageKeys._

  // Helper to simplify command creation below
  private implicit def taskToString(task: TaskKey[_]) = task.key.label

  // Make a single command to run tests and generate coverage report
  private def generateTestAndCoverageReportCommand(
      coverageCommand: sbt.TaskKey[scala.Unit]
  ): Command = {
    Command.command(
      "testAndCoverageReport",
      "Turns test coverage on, tests, generates a report, and turns coverage back off",
      detail = "Single-command method of generating a coverage report during development"
    ) { state => "coverageOn" :: clean :: test :: coverageCommand :: "coverageOff" :: state }
  }

  val rootSettings = Seq(
    coverageEnabled := true,
    coverageMinimum := 90,
    coverageFailOnMinimum := true,
    commands += generateTestAndCoverageReportCommand(coverageAggregate)
  )

  val commonSettings = rootSettings ++ Seq(
    commands += generateTestAndCoverageReportCommand(coverageReport)
  )

}

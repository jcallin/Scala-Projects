object Settings {
  import scoverage.ScoverageKeys._
  val commonSettings = Seq(
    coverageEnabled := true,
    coverageMinimum := 90,
    coverageFailOnMinimum := true
  )
}
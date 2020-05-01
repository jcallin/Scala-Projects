// Code formatters and style checkers

// https://github.com/scalameta/sbt-scalafmt
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.3.4")

// Scapegoat - static code analysis
// https://github.com/sksamuel/sbt-scapegoat
addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.1.0")

// Scala style - static code analysis for SBT
// http://www.scalastyle.org/sbt.html
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

// CI, coverage, testing

// Scala compiler unitest coverage plugin
// https://github.com/scoverage/sbt-scoverage
addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "1.6.0")

// Coveralls - integration with TravisCI for code coverage
// https://github.com/scoverage/sbt-coveralls
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.7")

// SuperSafe plugin for type checking Scalatest DSL
// For http://www.scalatest.org/supersafe for use with scalatest
resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"
// http://www.scalatest.org/supersafe
addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.10")

// Tools

// Dig into dependencies in sbt
// https://github.com/jrudolph/sbt-dependency-graph
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.10.0-RC1")

// Scala docs plugins

// sbt-unidoc - aggregation of Scaladocs across all projects
// https://github.com/sbt/sbt-unidoc
addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.4.2")

// ApiMappings for common Scala libraries.
// https://github.com/ThoughtWorksInc/sbt-api-mappings
addSbtPlugin("com.thoughtworks.sbt-api-mappings" % "sbt-api-mappings" % "2.0.2")

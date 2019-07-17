// Static code style checkers

// Scalinform - automatic compilation time code formatter
// https://github.com/sbt/sbt-scalariform
addSbtPlugin("org.scalariform" %% "sbt-scalariform" % "1.8.2")

//TODO add code analysis with scapegoat
// Scapegoat - static code analysis
// https://github.com/sksamuel/sbt-scapegoat
//addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.0.9")

// Coveralls - integration with TravisCI for code coverage
// https://github.com/scoverage/sbt-coveralls
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.7")

// Scala style - static code analysis for SBT
// http://www.scalastyle.org/sbt.html
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

// Scala compiler unitest coverage plugin
// https://github.com/scoverage/sbt-scoverage
addSbtPlugin("org.scoverage" %% "sbt-scoverage" % "1.6.0")

// Scala docs plugins

// sbt-unidoc - aggregation of Scaladocs across all projects
// https://github.com/sbt/sbt-unidoc
addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.4.2")

// ApiMappings for common Scala libraries.
// https://github.com/ThoughtWorksInc/sbt-api-mappings
addSbtPlugin("com.thoughtworks.sbt-api-mappings" % "sbt-api-mappings" % "2.0.2")

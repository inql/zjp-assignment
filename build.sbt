import sbt.Keys.version
import sbtsonar.SonarPlugin.autoImport.sonarProperties

lazy val root = (project in file("."))
  .settings(
    name := "GildedRose",

    version := "1.0",

    scalaVersion := "2.12.1",

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1",

    scapegoatVersion in ThisBuild := "1.3.5",


    sonarProperties ++= Map(
      "sonar.host.url" -> "http://localhost:9000",
      "sonar.projectName" -> "zjp-assignment",
      "sonar.projectKey" -> "zjp-assignment",
      "sonar.sources" -> "src/main/scala",
      "sonar.tests" -> "src/test/scala",
      "sonar.sourceEncoding" -> "UTF-8",
      "sonar.scala.scoverage.reportPaths" -> "target/scala-2.12/scoverage-report/scoverage.xml",
      "sonar.scala.scapegoat.reportPaths" -> "target/scala-2.12/scapegoat-report/scapegoat-scalastyle.xml"
    )
  )
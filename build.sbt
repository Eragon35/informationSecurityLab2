ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "informationSecurity"
  )

libraryDependencies += "net.codingwell" %% "scala-guice" % "5.1.0"


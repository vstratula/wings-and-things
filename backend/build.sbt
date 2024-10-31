import scala.collection.Seq

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.1"

lazy val root = (project in file("."))
  .settings(
    name := "backend"
  )
  .aggregate(
    `backend-api`,
    `backend-domain`
  )

lazy val commonSettings = Seq(
  organization := "com.wingsandthings",
  scalacOptions := Seq()
)

lazy val `backend-api` = project
  .settings(commonSettings: _*)
  .dependsOn(
    `backend-domain`        % "compile->compile;test->test",
  )

lazy val `backend-domain` = project
  .settings(commonSettings: _*)

import scala.collection.Seq

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.1"

// common settings for all modules
lazy val commonSettings = Seq(
  organization := "com.wingsandthings",
  scalacOptions := Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-encoding",
    "UTF-8",                 // Specify character encoding used by source files.
    "-language:higherKinds", // Allow higher-kinded types
    "-language:postfixOps",  // Allows operator syntax in postfix position (deprecated since Scala 2.10)
    "-feature",              // Emit warning and location for usages of features that should be imported explicitly.
    "-Xfatal-warnings",      // Fail the compilation if there are any warnings
  ),
)

// Определение модулей

// Общий модуль backend-domain, на который ссылаются оба приложения
lazy val `backend-domain` = project
  .in(file("backend-domain"))
  .settings(commonSettings *)
  .settings(
    name := "backend-domain",
    // Здесь можно добавить зависимости, специфичные для доменного модуля
    libraryDependencies += "org.typelevel" %% "cats-core" % "2.9.0",
  )

// Модуль backend-api, который зависит от backend-domain и включает свой основной класс
lazy val `backend-api` = (project in file("backend-api"))
  .dependsOn(`backend-domain`)
  .settings(commonSettings *)
  .settings(
    name                := "backend-api",
    Compile / mainClass := Some("com.wingsandthings.BackendApiApp"), // Укажите полный путь к классу MainApp
  )

// Определение основного проекта (корневого), который включает все модули
lazy val backend = (project in file("."))
  .aggregate(`backend-api`, `backend-domain`)

libraryDependencies ++= Seq(
  "com.beachape" %% "enumeratum-circe"    % Versions.enumeratum,
  "io.circe"     %% "circe-core"          % Versions.circe,
  "org.http4s"   %% "http4s-ember-server" % Versions.http4s,
  "org.http4s"   %% "http4s-circe"        % Versions.http4s,
  "org.http4s"   %% "http4s-dsl"          % Versions.http4s,
//  "org.typelevel"           %% "log4cats-slf4j"      % "2.7.0",
  "dev.zio"                 %% "zio-logging-slf4j" % Versions.zioLogging,
  "org.apache.logging.log4j" % "log4j-slf4j2-impl" % "2.22.0",
)

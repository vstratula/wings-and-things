libraryDependencies ++= Seq(
  "com.beachape" %% "enumeratum-circe"    % Versions.enumeratum,
  "io.circe"     %% "circe-core"          % Versions.circe,
  "org.http4s"   %% "http4s-ember-server" % Versions.http4s,
  "org.http4s"   %% "http4s-circe"        % Versions.http4s,
  "org.http4s"   %% "http4s-dsl"          % Versions.http4s,
)

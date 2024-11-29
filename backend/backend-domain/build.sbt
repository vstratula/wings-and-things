libraryDependencies ++= Seq(
  "dev.zio"      %% "zio"              % Versions.zio,
  "dev.zio"      %% "zio-interop-cats" % Versions.zioCats,
  "dev.zio"      %% "zio-test"         % Versions.zio % Test,
  "dev.zio"      %% "zio-test-sbt"     % Versions.zio % Test,
  "com.beachape" %% "enumeratum"       % Versions.enumeratum,
  "com.beachape" %% "enumeratum-cats"  % Versions.enumeratum,
  // logging
  "dev.zio"             %% "zio-logging"              % Versions.zioLogging,
  "dev.zio"             %% "zio-logging-slf4j2"       % Versions.zioLogging,
  "ch.qos.logback"       % "logback-classic"          % Versions.logbackClassic,
  "net.logstash.logback" % "logstash-logback-encoder" % Versions.logstashLogbackEncoder,
  //
)

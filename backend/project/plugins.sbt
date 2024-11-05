//val nexusUrl = sys.env.getOrElse("NEXUS_REPO", "https://nexusczr.shared-tooling.aws-us-east-1.usp.czrs.io:8443/repository")

//def resolver(name: String): Resolver =
//  Resolver.url(s"Artifactory Realm ${name.capitalize}", url(s"$nexusUrl/$name"))(Resolver.ivyStylePatterns)

//resolvers += resolver("ivy-releases")

//addSbtPlugin("com.bettingengine" % "be-sbt-utils"          % "3.3.5")
//addSbtPlugin("com.bettingengine" % "be-sbt-openapi-plugin" % "1.0.0")
//addSbtPlugin("org.scalameta"     % "sbt-scalafmt"          % "2.5.2")
//addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.2")
//addSbtPlugin("org.scalastyle"   %% "scalastyle-sbt-plugin" % "1.0.0")
//addSbtPlugin("org.scoverage"     % "sbt-scoverage"         % "2.1.0")
//addSbtPlugin("ch.epfl.scala"     % "sbt-scalafix"          % "0.12.1")

//addDependencyTreePlugin

//ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always

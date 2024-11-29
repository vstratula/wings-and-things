package com.wingsandthings

import com.comcast.ip4s.*
import com.wingsandthings.AppModule.Live
import com.wingsandthings.routes.Routes
import fs2.io.net.Network
import org.http4s.*
import org.http4s.dsl.Http4sDsl
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.*
import zio.*
import zio.interop.catz.*
import zio.logging.backend.SLF4J
import zio.managed.*

object BackendApiApp extends CatsApp with Http4sDsl[Task] {

  private type Env = Live.Env

  override def run: ZIO[Any & ZIOAppArgs & Scope, Any, Any] =
    makeServer
      .tapZIO(_ => ZIO.logInfo("Server has been started."))
      .useForever
      .provide(Live.layer)
      .foldCauseZIO(
        err => ZIO.logErrorCause(s"Server failed with error: ${err.prettyPrint}", err).exitCode,
        _ => ZIO.succeed(ExitCode.success),
      )

  // https://blog.pierre-ricadat.com/tuning-zio-for-high-performance
  override val bootstrap: ZLayer[ZIOAppArgs, Any, Any] =
    Runtime.disableFlags(RuntimeFlag.FiberRoots)
      >>> Runtime.removeDefaultLoggers
      >>> SLF4J.slf4j

  private def makeServer: ZManaged[Env, Throwable, Server] = {
    ZManaged.environmentWithManaged[Env] { has =>
      val host = host"0.0.0.0"
      val port = port"8080"

      given network: Network[Live.RIOWithEnv] = Network.forAsync[Live.RIOWithEnv]

      EmberServerBuilder
        .default[Live.RIOWithEnv]
        .withHttpApp(Routes.routes)
        .withHost(host)
        .withPort(port)
        .build
        .toManagedZIO
    }
  }

}

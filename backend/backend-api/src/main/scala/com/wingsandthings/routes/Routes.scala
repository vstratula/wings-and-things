package com.wingsandthings.routes

import cats.data.Kleisli
import com.wingsandthings.AppModule.Live
import com.wingsandthings.AppModule.Live.RIOWithEnv
import com.wingsandthings.repository.TempRepo
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Request, Response}
import zio.*
import zio.interop.catz.*

object Routes extends Http4sDsl[Live.RIOWithEnv] {
  val routes: Kleisli[RIOWithEnv, Request[RIOWithEnv], Response[RIOWithEnv]] =
    HttpRoutes
      .of[Live.RIOWithEnv] { case GET -> Root / "hello" =>
        Ok(
          (for {
            _ <- TempRepo.doSomething()
          } yield "Hello, Joe")
            .mapError(err => new Exception(err)),
        )
      }
      .orNotFound

}

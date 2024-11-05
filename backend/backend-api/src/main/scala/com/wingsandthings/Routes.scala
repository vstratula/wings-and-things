package com.wingsandthings

import cats.data.Kleisli
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Request, Response}
import zio.*
import zio.interop.catz.*

object Routes extends Http4sDsl[Task] {

  val routes: Kleisli[Task, Request[Task], Response[Task]] =
    HttpRoutes
      .of[Task] { case GET -> Root / "hello" =>
        Ok(for {
          _ <- ZIO.logInfo("Req -> Resp")
        } yield "Hello, Joe")
      }
      .orNotFound

}

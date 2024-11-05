//package com.wingsandthings
//
//import org.http4s.*
//import org.http4s.dsl.Http4sDsl
//import org.http4s.implicits.*
//import org.http4s.server.Router
////import org.http4s.server.blaze.*
//
//import org.http4s.blaze.server.BlazeServerBuilder
//import org.http4s.server.middleware.CORS
//import zio.*
//import zio.interop.catz.*
//
//trait HelloRepository {
//  def getHello(name: String): ZIO[AppEnvironment, Nothing, String]
//}
//
//trait AppEnvironment extends Console with Clock {
//  val helloRepository: HelloRepository
//}
//
//object Main extends App {
//
//  type AppTask[A] = RIO[AppEnvironment, A]
//
//  val dsl: Http4sDsl[AppTask] = Http4sDsl[AppTask]
//  import dsl.*
//
//  val httpApp: HttpApp[AppTask] = Router[AppTask](
//    "/" -> HttpRoutes.of[AppTask] { case GET -> Root / "hello" / name =>
//      Ok(ZIO.serviceWithZIO[AppEnvironment](_.helloRepository.getHello(name)))
//    },
//  ).orNotFound
//
//  val program = for {
//    server <- ZIO
//      .runtime[AppEnvironment]
//      .flatMap { implicit rts =>
//        BlazeServerBuilder[AppTask]
//          .bindHttp(8080, "0.0.0.0")
//          .withHttpApp(CORS(httpApp))
//          .serve
//          .compile
//          .drain
//      }
//  } yield server
//
//  val runEnv = ZLayer.succeed(new AppEnvironment {
//    val helloRepository = new HelloRepository {
//      def getHello(name: String): ZIO[AppEnvironment, Nothing, String] = ZIO.succeed(s"Hello $name")
//    }
//  })
//
//  def run(args: List[String]) =
//    program
//      .provide(runEnv)
////      .useForever
////        .provide(Live.layer)
//      .foldCauseZIO(
//        err => ZIO.logErrorCause(s"Server failed with error: ${err.prettyPrint}", err).exitCode,
//        _ => ZIO.succeed(ExitCode.success),
//      )
//}

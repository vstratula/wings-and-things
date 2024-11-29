package com.wingsandthings.repository

import zio.{IO, ULayer, ZIO, ZLayer}

trait TempRepo {
  def doSomething(): IO[String, Unit]
}

object TempRepo {
  def doSomething(): ZIO[TempRepo, String, Unit] = ZIO.serviceWithZIO[TempRepo](_.doSomething())
}

final class TempRepoLive extends TempRepo {

  override def doSomething(): IO[String, Unit] = ZIO.logInfo("Repository interaction !!!!!!")
}

object TempRepoLive {
  lazy val layer: ULayer[TempRepoLive] = ZLayer.succeed(new TempRepoLive)
}

package com.wingsandthings

import com.wingsandthings.repository.{TempRepo, TempRepoLive}
import zio.*

object AppModule {
  object Live {
    type Env = ZAny & TempRepo

    type RIOWithEnv[A] = RIO[Env, A]

    lazy val layer: ULayer[Env] = TempRepoLive.layer
  }
}

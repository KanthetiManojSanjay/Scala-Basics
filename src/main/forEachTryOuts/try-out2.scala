package main.scala.tryout.forEachTryOuts

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureForeach2 extends App {

  val step1: Future[String] = Future{
    throw new IllegalStateException()
  }
  step1.foreach(println)

  Thread.sleep(1000) //just keeping it alive
}

package main.scala.tryout.forEachTryOuts

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureForeach1 extends App {

  val step1: Future[String] = Future{
    "Work Done"
  }
  step1.foreach(println)
  //println is the function that will be applied to the value in the future

  Thread.sleep(1000) //just keeping it alive
}


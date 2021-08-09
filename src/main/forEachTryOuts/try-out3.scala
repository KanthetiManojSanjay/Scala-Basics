package main.scala.tryout.forEachTryOuts

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureForeach3 extends App {

  val step1: Future[String] = Future{
    "Work Done"
  }
  val step2 = step1.map(res_step1=> res_step1.count(x=>x.isLower))

  val step3 = step2.map(res_step2 => res_step2 >10)

  step3.foreach(println) // fasle - prints the value in the future
  step2.foreach(println)// 6- value in step2
  step1.foreach(println) // Work Done

  Thread.sleep(1000) //just keeping it alive
}



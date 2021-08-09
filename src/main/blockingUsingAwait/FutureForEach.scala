package main.scala.tryout.blockingUsingAwait

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FutureForeach extends App {

  val step1: Future[String] = Future{
    "Work Done"
  }
  val step2 = step1.map(res_step1=> res_step1.count(x=>x.isLower))

  val step3 = step2.map(res_step2 => res_step2 >10)

  val result = Await.result(step3, 1 second)
  println(result)

  println("End of program")

}
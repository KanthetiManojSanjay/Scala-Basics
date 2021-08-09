package main.scala.tryout.futuresCallback

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FuturesCallBack extends App {
  val step1: Future[String] = Future{
    if(false) "Work Done" else throw new IllegalStateException()
  } //Toggle the Boolean value and see what happens
  step1.onSuccess{
    case x=> println(x)
  }
  step1.onFailure{
    case y=> println(y.printStackTrace())
  }
  Thread.sleep(1000)
}

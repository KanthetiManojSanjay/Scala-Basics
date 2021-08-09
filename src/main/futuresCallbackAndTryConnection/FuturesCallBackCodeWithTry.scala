package main.scala.tryout.futuresCallbackAndTryConnection

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success,Failure} //imports the case match values

object FuturesCallBackCode extends App {
  val step1: Future[String] = Future{
    if(true) "Work Done" else throw new IllegalStateException()
  } //Toggle the Boolean value and see what happens

  step1.onComplete{
    case Success(x) => println(x)
    case Failure(ex) => println(ex.printStackTrace())
  }
  Thread.sleep(1000)
}

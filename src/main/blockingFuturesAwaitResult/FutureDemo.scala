package main.scala.tryout.blockingFuturesAwaitResult

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FutureDemo extends App {

  def greet(name: String) = {
    "Hello " + name
  }

  val greeting = Future {
    Thread.sleep(100) // Simulating delay
    greet("Jack")
  }

  /* Await.result() waits for the specified time
     for the Future block to complete and
     returns the value inside the Future object */
  val result = Await.result(greeting, 1 second)
  println(result)

  println("End of program")
}

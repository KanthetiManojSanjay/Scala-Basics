package main.scala.tryout.blockingFuturesAwaitReady

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

  /* Await.ready() waits for the specified time
   for the Future block to complete and
   returns the Future object */
  val result = Await.ready(greeting, 1 second)
  println(greeting.value.get.getOrElse("Process not complete yet"))

  println("End of program")
}

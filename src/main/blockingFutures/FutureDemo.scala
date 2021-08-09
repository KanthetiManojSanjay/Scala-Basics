package main.scala.tryout.blockingFutures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureDemo extends App {

  def greet(name: String) = {
    "Hello " + name
  }

  val greeting = Future {
    Thread.sleep(100) // Simulating delay
    greet("Jack")
  }

  // greeting doesn't have the result yet
  println(greeting.value.getOrElse("Process not complete yet"))

  println("End of program")
}
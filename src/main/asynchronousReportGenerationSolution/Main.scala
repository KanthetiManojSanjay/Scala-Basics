package main.scala.tryout.asynchronousReportGenerationSolution

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Main {

  case class Employee(name: String, salary: Double)

  //A mock method simulating service call
  def GetFinancialDetails(): Employee = {
    Thread.sleep(2000) // Simulating a delay
    Employee("John",50000.0)
  }

  case class Dependants(name: String, relationship: String)
  //A mock method simulating service call
  def GetDependentDetails(): List[Dependants] = {
    Thread.sleep(2000) // Simulating a delay
    List(Dependants("Margret", "Wife"), Dependants("Joe", "Son"))
  }

  def main(args: Array[String]): Unit = {

    //Passing Emp id to generate the report
    //Getting the financial details asynchronously
    val finData = Future {
      GetFinancialDetails()
    }
    //Getting the dependant details at the same time
    val depData = Future {
      GetDependentDetails()
    }
    //Printing the values from the future
    finData.foreach(println)
    depData.foreach(println)
    Thread.sleep(8000) //just keeping the thread alive to see the output
  }
}

package main.scala.tryout.asynchronousReportGenerationUsingCallback

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Main {

  case class Employee(name: String, salary: Double)

  //A mock method simulating service call
  def GetFinancialDetails(): Employee = {
    Thread.sleep(2000) // Simulating a delay
    Employee("John",50000.0)
  }

  case class Dependents(name: String, relationship: String)
  //A mock method simulating service call
  def GetDependentDetails(): List[Dependents] = {
    Thread.sleep(2000) // Simulating a delay
    List(Dependents("Margret", "Wife"), Dependents("Joe", "Son"))
  }

  def main(args: Array[String]): Unit = {

    //Passing Emp id to generate the report
    //Getting the financial details asynchronously
    val finData: Future[Employee] = Future {
      GetFinancialDetails()
    }
    //Getting the dependant details at the same time
    val depData: Future[List[Dependents]] = Future {
      GetDependentDetails()
    }

    val noOfDependents = depData.map(listDep => listDep.count(dep=> true))
    //Printing the values from the future
    finData.onComplete{
      case Success(data) => println(data)
      case Failure(ex) => println("Error")
    }

    depData.onComplete{
      case Success(data) => println(data)
      case Failure(ex) => println("Error")
    }

    noOfDependents.onComplete{
      case Success(data) => println(data)
      case Failure(ex) => println("Error")
    }

    Thread.sleep(8000) //just keeping the thread alive to see the output
  }
}

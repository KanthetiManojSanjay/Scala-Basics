package main.scala.tryout.implicitTryouts

object ImplicitData extends App{

  implicit val company = "Infosys"

  def display (implicit cName:String) = {
    println("The company is : " + cName)
  }
  display //Parameter is implicitly taken

  display("EdgeVerve") // Parameter can be explicitly given

}
package main.scala.tryout.implicitTryouts

object ImplicitData2 extends App{

  implicit val company = "Limited"

  def display (cName1:String)(implicit cName2:String) = {
    println("The company is : " + cName1+" "+cName2)
  }
  //display //Gives Error because method takes one explicit parameter

  display("Infosys") // Parameter can be explicitly given

  display("My")("Own") // both parameters can be explicitly given

}

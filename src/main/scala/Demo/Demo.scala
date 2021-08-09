package Demo

import java.util.Date

object Demo {


  def main(args: Array[String]) {
    println("Hello world!")
    val name = "mark"
    val age = 18
    println(s"$name is $age years old") // s interpolation which is not type safe
    println(f"$name%s is $age%d years old") // f string interpolation which is typesafe
    println(s"Hello \nworld")
    println(raw"Hello \nworld") // raw interpolation

    // IF-ELSE (as statements)
    val x = 10
    var res = ""
    if (x == 10) {
      res = "x==10"
    } else {
      res = "x!=10"
    }
    println(res)

    val res2 = if (x == 10) "x==10" else "x!=10" // as expression
    println(res2)

    //WHILE loop
    var y = 1
    while (y < 10) {
      println(s"y=$y")
      y += 1
    }

    // DO-WHILE loop
    var z = 1
    do {
      println(s"z=$z")
      z += 1
    } while (z < 10)


    //FOR loop
    for (i <- 1 to 5) {
      println("i to " + i)
    }

    for (j <- 1 until 6) {
      println("j until " + j)
    }

    for (i <- 1 to 9; j <- 1 to 3) {
      println(s"i to $i and j to  $j")
    }

    var lst = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (i <- lst; if i < 6) {
      println("i to " + i)
    }

    val result = for {
      i <- lst
      if i < 6} yield { // for loop as expression
      i * i
    }
    println(s"result is $result")

    // Matches
    val age1 = 22 // valid for strings as well
    age1 match {
      case 20 => println(s"age $age1")
      case 18 => println(s"age $age1")
      case 10 => println(s"age $age1")
      case _ => println("default")
    }

    val i = 9
    i match {
      case 1 | 3 | 5 | 7 | 9 => println("Odd number")
      case 2 | 4 | 6 | 8 => println("Even number")
    }

    println(Math.+()) // default values are considered
    println(Math.+(2)) // here  value 2 is assigned to 1st parameter
    println(Math.+(1, 2))
    println(substract(2, 1))
    println(multiply(2, 3))
    println(divide(6, 2))
    println(Math square 3) // as it has single argument or Math.square(3)
    add2(2, 3)

    var add = (x: Int, y: Int) => x + y // Anonymous function
    println("Anonymous function " + add(2, 4))
    val res5 = math(4, 3, _ + _) // or (x, y) => x + y. Used _ as wildcard
    println(s"HOF $res5")

    val res1 = math(4, 3, (x, y) => x min y)
    println(s"HOF minvalue is $res1")

    val res4 = math(4, 3, (x, y) => x min y)
    println(s"HOF minvalue is $res4")

    val res3 = math2(4, 3, 2, (x, y) => x * y)
    println(s"HOF multiply is $res3")

    val sum = (x: Int, y: Int, z: Int) => x + y + z
    val f = sum(10, 20, _: Int) // Partially applied functions
    println("Partial function " + f(30))

    val date = new Date();
    val newLog = log(date, _: String)

    newLog("Message1")

    num1 = 12
    println(closureAdd(2))
    println(num1) // closure changed num1 value from 12 to 14
    println(add3(2)(3))
    val sum40 = add3(40) // 40 will be passed as 1st arg to add3 method  - Currying
    println(sum40(100)) //100 is 2nd arg

    println(add4(10)(20))

    val sum50 = add4(10)_    //partial application in currying
    println(sum50(40))

  }


  object Math {
    def +(x: Int = 10, y: Int = 20): Int = { // can have operators as methodName
      return x + y
    }

    def square(x: Int) = x * x
  }

  // FUNCTIONS
  def substract(x: Int, y: Int): Int = {
    x - y //return keyword is not required. Statement in lastLine will be considered as return value
  }

  def multiply(x: Int, y: Int) = x * y // If we are certain that returnType is Int then we can remove that as well

  def divide(x: Int, y: Int): Int = x / y

  def add2(x: Int, y: Int): Unit = { // As it doesn't return any value so the returnType is Unit
    println(x + y)
  }

  def math(x: Double, y: Double, f: (Double, Double) => Double): Double = f(x, y) // Higher order function

  def math2(x: Double, y: Double, z: Double, f: (Double, Double) => Double): Double = f(f(x, y), z) // Higher order function

  def log(date: Date, message: String) = {
    println(date + " " + message)
  }

  var num1 = 10 // Impure closure if the datatype is var & Pure closure if it is val
  val closureAdd = (x: Int) => {
    num1 = x + num1
    num1
  } // Closure is a function which uses 1 or more variables declared outside the function

  def add3(x: Int) = (y: Int) => x + y // function Currying - means transforming a function that takes multiple args into function with 1 arg

  def add4(x: Int)(y: Int) = x + y // scala currying


}

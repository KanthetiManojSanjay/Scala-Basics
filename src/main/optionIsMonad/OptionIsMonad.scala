package main.scala.tryout.optionIsMonad


object OptionIsAMonad extends App{

  val countData : Option[Int] = Some(10)
  println(countData)      //Some(10)
  println(countData.getOrElse(0))    //10

  val countData2 : Option[Int] = None
  println(countData2)      //None
  println(countData2.getOrElse(0))    //0

}
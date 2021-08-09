package main.scala.tryout.optionsWithFlatMaps

object OptionWithFlatmap extends App
{
  val ListOfOptions = List(Some(10),None,Some(20),None,Some(30),None)
  val ListFiltered = ListOfOptions.flatMap(x=>x)
  //flatmap extracts the values out of the Some and ignores the None. We will see this in some more detail as we proceed



  println(ListOfOptions) // List(Some(10), None, Some(20), None, Some(30), None)
  println(ListFiltered) //List(10, 20, 30)

}

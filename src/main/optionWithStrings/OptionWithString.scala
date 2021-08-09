package main.scala.tryout.optionWithStrings


object OptionWithString extends App{
  //Uncomment the below line before running this code
  //val stringOption1 : Option[String] = "Infosys" //Error Option needs a Some(String)
  val stringOption2 : Option[String] = Some("Infosys") //Some(String)
  val stringOption3 : Option[String] = null //None
}

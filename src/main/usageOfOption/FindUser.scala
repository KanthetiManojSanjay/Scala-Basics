package main.scala.tryout.usageOfOption

case class User(name:String,age:Int)

object UserRepo{
  private val userDatabase=Map("Rob"->User("Rob",31), "Bob"->User("Bob",33))

  def findUser(name:String):Option[User]=userDatabase.get(name)
}

object FindUser extends App {
  //finding a user that does not exist
  val user1 = UserRepo.findUser("Thomas").getOrElse("No User found")
  //finding a user that exists
  val user2 = UserRepo.findUser("Rob").getOrElse("No User found")
  println(user1) // No User found
  println(user2) // Rob
}
package org.szhua

object ClassApp extends  App {

  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer")

  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(2, 2)
  //Instances of case classes are compared by value, not by reference:
  if (point == anotherPoint) {
    println(point + " and " + anotherPoint + " are the same.")
  } else {
    println(point + " and " + anotherPoint + " are different.")
  } // Point(1,2) and Point(1,2) are the same.
  if (point == yetAnotherPoint) {
    println(point + " and " + yetAnotherPoint + " are the same.")
  } else {
    println(point + " and " + yetAnotherPoint + " are different.")
  } // Point(1,2) and Point(2,2) are different.


  val newId: Int = IdFactory.create()
  println(newId) // 1
  val newerId: Int = IdFactory.create()
  println(newerId) // 2




}

//class
//You can define classes with the class keyword,
// followed by its name and constructor parameters:
class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit = println(prefix + name + suffix)
}

//case class
//you can define case classes with the case class keywords
//You can instantiate case classes without the new keyword:
case class Point(x: Int, y: Int)



//Objects are single instances of their own definitions.
// You can think of them as singletons of their own classes.
object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}
//Traits
//You can define traits with the trait keyword:
trait Greeter2 {
  def greet(name: String): Unit
}
//Traits can also have default implementations:
trait  Greeter3{
  def  greet(name:String):Unit={
    println("Hello, " + name + "!")
  }
}
//You can extend traits with the extends keyword and override an implementation with the override keyword:
//Here, DefaultGreeter extends only one single trait, but it could extend multiple traits.
class  DefaultGreeter(prefix: String, postfix: String) extends  Greeter3
class CustomizableGreeter(prefix: String, postfix: String) extends Greeter3 {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}



//Main Method
//The main method is the entry point of a Scala program. The Java Virtual Machine requires a main method, named main, that takes one argument: an array of strings.
//
//Using an object, you can define the main method as follows:

object  Main{
  def main(args: Array[String]): Unit = {
      println("enter Main method")
  }
}



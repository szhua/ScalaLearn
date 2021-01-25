package org.szhua

import scala.collection.mutable.ArrayBuffer

object TraitsApp extends  App {


  /**
   * Traits
   *   Traits are used to share interfaces and fields between classes.
   *   They are similar to Java 8’s interfaces.
   *   Classes and objects can extend traits, but traits cannot be instantiated and therefore have no parameters.
   */


  val iterator = new IntIterator(10)
  iterator.next()  // returns 0
  iterator.next()  //// returns 1




  //Subtyping
  //Where a given trait is required, a subtype of the trait can be used instead.
  val animals =   ArrayBuffer.empty[Pet]
  val dog = new Dog("Harry")
  val cat = new Cat("Sally")
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))  // Prints Harry Sally


}


//A minimal trait is simply the keyword trait and an identifier:
trait HairColor

//Traits become especially useful as generic types and with abstract methods.
//trait Iterator[A] {
//  def hasNext: Boolean
//  def next(): A
//}


trait Iterator[A] {
  def hasNext: Boolean
  def next(): A
}
class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0
  override def hasNext: Boolean = current < to
  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}


trait Pet {
  val name: String
}

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet
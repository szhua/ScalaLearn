package org.szhua

object Tuples extends App {

  /**
   * Tuples 原组
   * In Scala, a tuple is a value that contains a fixed number of elements, each with its own type.
   * Tuples are immutable.
   */
    //A tuple with two elements can be created as follows:
  val ingredient = ("szhua",26)

  //Accessing the elements
  //One way of accessing tuple elements is by position.
  // The individual elements are named _1, _2, and so forth.
  println(ingredient._1)
  println(ingredient._2)

  //Pattern matching on tuples
  //A tuple can also be taken apart using pattern matching:
  val(name,quantity) =ingredient
  println(name)
  println(quantity)

  val planets =
    List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
      ("Mars", "是"), ("Jupiter", 778.3))
  planets.foreach{
    case ("Mars", distance) =>
      println(s"Our planet is $distance million kilometers from the sun")
    case _ =>
  }


  /**
   * Tuples and case classes
   * Users may sometimes find it hard to choose between tuples and case classes.
   * Case classes have named elements.
   * The names can improve the readability of some kinds of code.
   * In the planet example above, we might define case class Planet(name: String, distance: Double) rather than using tuples.
   */





}

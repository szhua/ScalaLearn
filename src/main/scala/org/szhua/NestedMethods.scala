package org.szhua

import scala.annotation.tailrec

object NestedMethods extends  App {


  /**
   * In Scala it is possible to nest method definitions.
   * The following object provides a factorial method for computing the factorial of a given number:
   */

  def factorial(x: Int): Int = {
    @tailrec
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x, 1)
  }

  factorial(100)


}

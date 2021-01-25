package org.szhua

object DefaultParameterValues extends  App {

  def log(message: String, level: String = "INFO") = println(s"$level: $message")
  log("sss")
  log("ssss","WARNING")


  /**
   * The parameter level has a default value so it is optional.
   * On the last line, the argument "WARNING" overrides the default argument "INFO".
   * Where you might do overloaded methods in Java, you can use methods with optional parameters to achieve the same effect.
   * However, if the caller omits an argument, any following arguments must be named.
   */

  class PointP(val x: Double = 0, val y: Double = 0)

  val point1 = new PointP(y = 1)


  //NAMED ARGUMENTS
  //When calling methods, you can label the arguments with their parameter names like so:

  def printName(first: String, last: String): Unit = {
    println(first + " " + last)
  }
  printName(last = "Zhihua",first = "Shan")
  printName(first = "Shan",  "Shan")





}

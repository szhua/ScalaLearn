package org.szhua

import java.util.Locale

object CurryingApp extends App {

  //Example
  //Starting with an initial value of 0,
  // foldLeft here applies the function (m, n) => m + n to each element in the List
  // and the previous accumulated value.
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((x,y)=>x+y)
  println(res)



  //DRIVE TYPE INFERENCE
  //It so happens that in Scala, type inference proceeds one parameter list at a time.
  // Say you have the following method:
  def foldLeft1[A, B](as: List[A], b0: B, op: (B, A) => B) = ???

 // Then you’d like to call it in the following way, but will find that it doesn’t compile:
 //  def notPossible = foldLeft1(numbers, 0, _ + _)

  def firstWay = foldLeft1[Int, Int](numbers, 0, _ + _)
  def secondWay = foldLeft1(numbers, 0, (a: Int, b: Int) => a + b)

  def foldLeft2[A, B](as: List[A], b0: B)(op: (B, A) => B) = ???
  //Currying resolve   【type inference proceeds one parameter list at a time.】
  def possible = foldLeft2(numbers, 0)(_ + _)

  //def execute(arg: Int)(implicit ec: scala.concurrent.ExecutionContext) = ???


  /**
   * IMPLICIT PARAMETERS
   * To specify only certain parameters as implicit, they must be placed in their own implicit parameter list.
   * An example of this is:
   * @param x
   * @param locale
   */
  def test1(x: String)(implicit locale: Locale): Unit = {
    def test1Helper(args: String)(implicit locale: Locale): Unit = {
      println(s"args=$args, locale=$locale")
    }
    test1Helper(x)
  }
  //显示调用隐式参数，隐式参数的柯里化不能使用部分参数传递
  test1("hello world")(Locale.CHINA)

  val testNumbers =List(1,2,3,4,5,6,7,8,9)

  //val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  //我们可以给定多参数列表的一部分参数列表（如上述的z）来形成一个新的函数（partially applied function），达到复用的目的，如下所示：
  val numberFunc = testNumbers.foldLeft(List[Int]())_
  val squares = numberFunc((xs, x) => xs :+ x*x)
  println(squares) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

  val cubes = numberFunc((xs, x) => xs :+ x*x*x)
  println(cubes)  // List(1

}

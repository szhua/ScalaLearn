package org.szhua


/**
 * Hello world!
 *
 */
object ScalaApp extends App {
     println( "Hello World!" )

///Expressions are computable statements:
     1+1
     println(1+1)

//Values
     val  x =1+1
     println(x)
     ///Values cannot be re-assigned:
     //x=10
    // The type of a value can be omitted and inferred, or it can be explicitly stated:
     val y :Int =1+10

///Variables
     var t  = 1+1
     t =10

///blocks
     println({
          val x = 1 + 1
          x+1
     })

///functions

    ///an anonymous function
    val functionA = (x:Int)=>x+1
    println(functionA)
    //multiple parameters:
    val add = (x:Int,y:Int)=>{
         var result =x+1
         result =result+1
         result+y
    }
    println(add(1,2))
    ///have no parameters
    val printHelloWorld =()=>println("Hello World")
    printHelloWorld()

///methods
  //Methods look and behave very similar to functions, but there are a few key differences between them.
    def add2(x:Int,y:Int)=x+y
    println(add2(1,2))
     //A method can take multiple parameter lists:
     ///柯里化函数   The Corryzation function
     def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
     println(addThenMultiply(1,2)(3))
     ///Or no parameter lists at all:
     def name:String = System.getProperty("user.name")
     println(s"Hello: $name")

     //The last expression in the body is the method’s return value.
     // (Scala does have a return keyword, but it is rarely used.)
     def getSquareString(input: Double): String = {
          val square = input * input
          square.toString
     }
     println(getSquareString(11.10))



}

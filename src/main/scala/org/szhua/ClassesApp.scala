package org.szhua

object ClassesApp extends  App {

   //The keyword new is used to create an instance of the class
   val user =new  User
   println(user)

   val point1 = new Point(2, 3)
   println(point1.x)  // 2
   println(point1)
   val point2 = new Point2
   point2.x=99
   point2.y = 101 // prints the warning
   point2.getDx =1000





}

///Defining a class
    //A minimal class definition is simply the keyword class and an identifier.
    // Class names should be capitalized.
class User


/**
 * he keyword new is used to create an instance of the class.
 * User has a default constructor which takes no arguments because no constructor was defined.
 * However, you’ll often want a constructor and class body. Here is an example class definition for a point:
 */
class Point(var x: Int, var y: Int) {

   def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
   }

   override def toString: String = s"($x, $y)"
}

//Private Members and Getter/Setter Syntax
//Members are public by default. Use the private access modifier to hide them from outside of the class.
//In this version of the Point class, the data is stored in private variables _x and _y.
// There are methods def x and def y for accessing the private data.
// def x_= and def y_= are for validating and setting the value of _x and _y.
// Notice the special syntax for the setters: the method has _= appended to the identifier of the getter and the parameters come after.
class Point2 {
   private var _x = 0
   private var _y = 0
   private val bound = 100
   private var dx = 0


   //**

   def getDx = dx
   def getDx_= (newValue: Int): Unit = {
      if (newValue < bound) dx = newValue else printWarning()
   }


   def x = _x
   def x_= (newValue: Int): Unit = {
      if (newValue < bound) _x = newValue else printWarning()
   }

   def y = _y
   def y_= (newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning()
   }

   private val  printWarning =()=> println("WARNING: Out of bounds")
}



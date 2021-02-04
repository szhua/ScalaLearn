package org.szhua.test

class  SS(){

}



object SS {
   println("ss init")
   def main(args: Array[String]): Unit = {
      println("main")
      println(SS())
   }
   def apply(): SS = {
      println("ssss")
      new SS()
   }
}

package org.szhua


import scala.collection.mutable.ListBuffer
import org.szhua.TestFun

trait TraitTest  {

  println("ssss")

  private val initCode = new ListBuffer[() => Unit]

//  override def delayedInit(body: => Unit): Unit = {
//    println("delayInit")
//    println("TraitInit")
//   // initCode += (() => body)
//  }

  def main(args: Array[String]): Unit = {
    for (elem <- initCode) {
      elem()
    }
  }

}

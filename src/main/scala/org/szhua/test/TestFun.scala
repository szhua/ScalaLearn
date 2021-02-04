package org.szhua.test

trait  TestFun {
  def delayedInit(x: => Unit): Unit
}

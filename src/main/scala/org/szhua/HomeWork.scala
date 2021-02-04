package org.szhua

import scala.util.control.Breaks

object HomeWork extends  App {

  println(sumPrimeNumber(10000))

  /**
   *  1.使用Breaks.breakable{
   *    进行 break 跳出
   *  }
   *  2. 使用 for（ if） filter 元素 进行条件 for循环。
   * @param end
   * @return
   */
  def  sumPrimeNumber(end:Int):Int={
    var sum = 0
    if(end>=2){
      val break = new Breaks
      break.breakable{
        for(x <- 2 until end+1 ){
          var marked =true
          val innerBreak =new Breaks
          innerBreak.breakable{
            for (y <- 2 until x if marked){
              if(x%y==0&&x!=2){
                 marked =false
              }
            }
          }
          if(marked) {
             println(x)
             sum+=x
          }
        }
      }
    }
    sum
  }




}




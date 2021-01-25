package org.szhua

object HomeWork extends  App {

  println(sumPrimeNumber(10000))

  def  sumPrimeNumber(end:Int):Int={
    var sum = 2
    var marked = true
    if(end>=2){
       for (x<- 1 until end+1 ; y<- 2 until x){
            if(x%y==0&&x!=2){
               marked =false
            }
            if(y==x-1){
               if(marked){
                 sum+=x
               }
               marked =true
            }
       }
    }
    sum
  }




}




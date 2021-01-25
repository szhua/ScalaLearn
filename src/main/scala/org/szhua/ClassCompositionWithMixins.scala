package org.szhua

object ClassCompositionWithMixins extends  App {


  val richIterator = new RichStringIterator("Scala")
  richIterator.forEach(ch=>{
    println(ch.toUpper)
  })


}


abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next(): T
}

trait  RichIterator extends  AbsIterator{
   def  forEach(f:T=>Unit) = {
      while (hasNext){
          f(next())
      }
   }
}





class  StringIterator(val s: String) extends  AbsIterator{
  override type T = Char
  private var i:Int =0
  override def hasNext: Boolean = i < s.length
  override def next(): Char = {
     val ch = s charAt i
     i+=1
     ch
  }
}



class  RichStringIterator(override val s :String ) extends  StringIterator(s) with  RichIterator
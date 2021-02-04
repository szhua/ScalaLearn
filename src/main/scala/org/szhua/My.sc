import java.util.Locale

implicit  def  locale2 =Locale.CHINA

val site = "Sina" :: "Google" :: "Baidu" :: List[Math]()

val site = "Sina" :: "Google" :: "Baidu" :: Nil

val ss = 11::List()

val ss = 11::List[Long]()

val partialFunction ={
  case i:Int => i*5
}
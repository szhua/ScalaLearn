package org.szhua
import scala.math._


object Logger {
  def info(message: String): Unit = println(s"INFO: $message")
}
/**
 * An object is a class that has exactly one instance.
 * It is created lazily when it is referenced, like a lazy val.
 */
object SingletonObjects  extends  App {
  val project1 = new Project("TPS Reports", 1)
  val project2 = new Project("Website redesign", 5)
  Logger.info("Created projects")


  val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")

 val result  = scalaCenterEmail match {
    case Some(email)=>
      s"""Registered an email
         |Username: ${email.username}
         |Domain name: ${email.domainName}
         """.stripMargin
    case None =>   println("Error: could not parse email")
  }


}


class Project(name: String, daysToComplete: Int)


/**
 * The class Circle has a member area which is specific to each instance,
 * and the singleton object Circle has a method calculateArea which is available to every instance.
 *
 * @param radius
 */
case class Circle(radius: Double) {
  import Circle._
  def area: Double = calculateArea(radius)
}

object Circle {
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
}

class Email(val username: String, val domainName: String)
object Email {
  def fromString(emailString: String): Option[Email] = {
    emailString.split('@') match {
      case Array(a, b) => Some(new Email(a, b))
      case _ => None
    }
  }
}

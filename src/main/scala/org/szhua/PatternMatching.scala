package org.szhua

import scala.util.Random

/**
 * Pattern matching is a mechanism for checking a value against a pattern.
 * A successful match can also deconstruct a value into its constituent parts.
 * It is a more powerful version of the switch statement in Java and
 * it can likewise be used in place of a series of if/else statements.
 */
object PatternMatching  extends  App {


  //Syntax
  //A match expression has a value, the match keyword, and at least one case clause.
  val x: Int = Random.nextInt(10)
  val result = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }
  println(result)


  /**
   * Matching on case classes
   *
   * @param notification
   * @return
   */
  def showNotification(notification: Notification): String = {
    notification match {
      case Email1(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

  println(showNotification(someVoiceRecording))


  //Pattern guards
  //Pattern guards are simply boolean expressions which are used to make cases more specific.
  // Just add if <boolean expression> after the pattern.
  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email1(sender, _, _) if importantPeopleInfo.contains(sender) =>
        "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

  val importantEmail = Email1("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(showImportantNotification(someSms, importantPeopleInfo)) // prints You got an SMS from 123-4567! Message: Are you there?
  println(showImportantNotification(someVoiceRecording, importantPeopleInfo)) // prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
  println(showImportantNotification(importantEmail, importantPeopleInfo)) // prints You got an email from special someone!
  println(showImportantNotification(importantSms, importantPeopleInfo)) // prints You got an SMS from special someone!


  //Matching on type only

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case p: Computer => p.screenSaverOn
  }
  println(goIdle(Computer("ss")))



  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }
  println(findPlaceToSit(Couch()))
}


//Matching on case classes
abstract class Notification

case class Email1(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification


abstract class Device
case class Phone(model: String) extends Device {
  def screenOff = "Turning screen off"
}
case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

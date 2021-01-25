package org.szhua


/**
 * Case classes are like regular classes with a few key differences which we will go over.
 * Case classes are good for modeling immutable data.
 * In the next step of the tour, we’ll see how they are useful in pattern matching.
 */
object CaseClassApp  extends  App {

  val frankenstein = Book("978-0486282114")
  val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
  println(message1.sender)  // prints guillaume@quebec.ca
  //When you create a case class with parameters, the parameters are public vals.
  //message1.sender = "travis@washington.us"  // this line does not compile

  //Comparison
  //Instances of case classes are compared by structure and not by reference:

  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val messagesAreTheSame = message2 == message3  // true

  //Copying
  //The recipient of message4 is used as the sender of message5 but the body of message4 was copied directly.
  val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
  println(message5.sender)  // travis@washington.us
  println(message5.recipient)// claire@bourgogne.fr
  println(message5.body)  // "Me zo o komz gant ma amezeg"


}
case class Book(isbn: String)

//When you create a case class with parameters, the parameters are public vals.
case class Message(sender: String, recipient: String, body: String)

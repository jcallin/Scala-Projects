package part2actors

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {
  val as = ActorSystem("first")

  class WordCountActor extends Actor {
    var totalWords = 0
    override def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        println(s"[word counter] I have received a message $message")
        totalWords += message.split(" ").length
      case other => println(s"[word counter] I cannot understand $other")
    }
  }

  // This returns an actor reference, the data structure that Akka exposes to the programmer
  // You purposefully cannot create instances of the WordCountActor class so that it cannot be inspected without using
  // the prescribed actor interface
  val wordCounter        = as.actorOf(Props[WordCountActor], "wordCounter")
  val anotherWordCounter = as.actorOf(Props[WordCountActor], "anotherWordCounter")

  wordCounter ! "This is a message"
  anotherWordCounter ! "This is another message"

  // If we want to extend Actor, we have to  use the Props instantiator like above
  class Person(name: String) extends Actor {
    override def receive: Receive = {
      case "hi" => println(s"Hi back, im $name")
      case _ =>
    }
  }

  val person = as.actorOf(Props(new Person("Bob")))
  person ! "hi"

  // Best practice is to create a 'props' method on each class which instantiates it
  object Person {
    def props(name: String) = Props(new Person(name))
  }

  val personBetter = as.actorOf(Person.props("BetterBob"))
  personBetter ! "hi"
}

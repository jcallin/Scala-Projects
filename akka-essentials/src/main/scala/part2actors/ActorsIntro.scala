package part2actors

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {
  val as = ActorSystem("first")

  class WordCountActor extends Actor {
    var totalWords = 0
    override def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        totalWords += message.split(" ").length
      case other => println(s"[word counter] I cannot understand $other")
    }
  }

  // This return an actor reference, the data structure that Akka exposes to the programmer
  // You purposefully cannot create instances of the WordCountActor class so that it cannot be inspected without using
  // the prescribed actor interface
  val wordCounter = as.actorOf(Props[WordCountActor], "wordCounter")

}

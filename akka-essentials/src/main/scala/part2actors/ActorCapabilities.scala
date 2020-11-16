package part2actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object ActorCapabilities extends App{

  class SimpleActor extends Actor  {
    // equivalent of 'this' in OO world
    context.self
    override def receive: Receive = {
      case "Hi!" => context.sender() ! "Hello, there!"
      case message: String => println(s"[ $self ] I have received $message")
      case number: Int => println(s"[simple actor] I have returned a Number: $number")
      case SpecialMessage(m) => println(s"[simple actor] I have returned a Number: $m")
      case SelfMessage(content) => self ! content
      case SayHiTo(ref) => ref ! "Hi"
      case WirelessPhoneMessage(content, ref) => ref forward (content + "s") // Keep original sender and add 's'
    }
  }

  val system = ActorSystem("actorCapabilitiesSystem")
  val simpleActor = system.actorOf(Props[SimpleActor], "simpleActor")

  simpleActor ! "hello, actor"

  // 1 Messages can be of any type
  // a Message must be immutable
  // b message must be serializable (case classes and objects)
  simpleActor ! 42

  case class SpecialMessage(contents: String)
  simpleActor ! SpecialMessage("some special message")

  // 2. actors have information about their context and their self
  case class SelfMessage(content: String)
  simpleActor ! SelfMessage("I am an actor and I'm proud of it!")

  // 3. Actors can reply to messages
  val alice = system.actorOf(Props[SimpleActor], "alice")
  val bob = system.actorOf(Props[SimpleActor], "bob")

  case class SayHiTo(ref: ActorRef)
  // Alice says hi to Bob who receives the say hi to message and sends him the "Hi" message which is received and responded with "Hello, there"
  alice ! SayHiTo(bob)

  // context.sender() in this case is no one, so "Hello, there" will be delivered to the dead letters mailbox
  alice ! "Hi"

  // 5. Forwarding messages
  // D -> A -> B
  // Keeps the original sender "D" through the chain
  case class WirelessPhoneMessage(content: String, ref: ActorRef)

  // Alice forwards this to Bob. Bob receives distorted message "His" and original sender is noSender
  alice ! WirelessPhoneMessage("Hi", bob)


}

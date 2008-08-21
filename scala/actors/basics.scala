import scala.actors._
object SillyActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("I am acting")
      Thread.sleep(1000)
    }
  }
}

import scala.actors.Actor._;
val intActor = actor { react {
  case x: Int =>
    println("Got an Int: " + x)
}}

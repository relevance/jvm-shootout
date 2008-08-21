import scala.actors.Actor._;
val sillyActor2 = actor { 
  def emoteLater() { 
    val mainActor = self 
    actor { 
      Thread.sleep(1000) 
      mainActor ! "Emote" 
    } 
  } 
  var emoted = 0 
  emoteLater() 
  loop { 
    receive { 
      case "Emote" => 
	println("I'm acting!") 
      emoted += 1 
      if (emoted < 5) 
	emoteLater() 
      case msg => 
	println("Received: " + msg) 
    } 
  } 
} 

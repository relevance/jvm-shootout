case class Color(val red:Int, val green:Int, val blue:Int)

object ColorDemo {
  def colorString(c:Color) = c match {
    case Color(r,0,0) => "Red: " + r
    case Color(0,g,0) => "Green: " + g
    case Color(0,0,b) => "Blue: " + b

    case col:Color => {
      "R: " + col.red + ", " +
      "G: " + col.green + ", " +
      "B: " + col.blue
    }

    case null => "Invalid color"
  }
}
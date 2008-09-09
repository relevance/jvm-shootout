import org.scalatest.Suite

class ColorSuite extends Suite {
  def testPrintColor() {
    assert(ColorDemo.colorString(Color(255,0,0)) === "Red: 255")
    assert(ColorDemo.colorString(Color(0,255,0)) === "Green: 255")
    assert(ColorDemo.colorString(Color(0,0,255)) === "Blue: 255")
    assert(ColorDemo.colorString(Color(10,10,10)) === "R: 10, G: 10, B: 10")
  }
}
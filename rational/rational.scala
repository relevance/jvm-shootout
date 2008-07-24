class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g
  def this(n: Int) = this(n, 1)
  override def toString = numer + "/" + denom
  def +(that: Rational): Rational = 
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def *(that: Rational): Rational = 
    new Rational(numer * that.numer, denom * that.denom)
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
// use import Rational._ or move to a Preamble...
object Rational {
  implicit def intToRational(x: Int): Rational = new Rational(x,1)
}

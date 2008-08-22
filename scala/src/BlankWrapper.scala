// Scala
class CharWrapper(ch: Char) {
  def isWhitespace = Character.isWhitespace(ch)
}
//implicit def charWrapper(ch: Character) = new CharWrapper(ch)
class BlankWrapper(s: String) {
  def isBlank = s.isEmpty || s.forall(ch => ch.isWhitespace)
}
//implicit def stringWrapper(s: String) = new BlankWrapper(s)

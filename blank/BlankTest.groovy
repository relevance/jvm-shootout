class BlankTest extends GroovyTestCase {
  static {                             
    String.metaClass.isBlank = {
      length() == 0 || every { Character.isWhitespace(it.charAt(0)) }
    }
  }

  void testEmptyString() {
    assertTrue "".isBlank()
  }

  void testWhiteString() {
    assertTrue " ".isBlank()
  }

  void testNonBlankString() {
    assertFalse "foo".isBlank()
  }

}
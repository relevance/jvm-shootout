class LetterGradeTest extends GroovyTestCase {
  Object letterGrade(val) {
    switch(val) {
      case 90..100: return 'A'
      case 80..90:  return 'B'
      case 70..80:  return 'C'
      case 60..70:  return 'D'
      case 0..60:   return 'F'
      case ~"[ABCDFabcdf]": return val.toUpperCase()
      default:  throw new IllegalArgumentException("Not a valid grade: ${val}")
    }
  }
  void testNumbers() {
    assertEquals 'A', letterGrade(95)
    assertEquals 'B', letterGrade(85)
    assertEquals 'C', letterGrade(75)
    assertEquals 'D', letterGrade(65)
    assertEquals 'F', letterGrade(35)
  }
  void testLetters() {
    assertEquals 'A', letterGrade('a')
    assertEquals 'A', letterGrade('A')
  }
  void testInvalids() {
    shouldFail(IllegalArgumentException) {letterGrade("awesome")}
  }
}
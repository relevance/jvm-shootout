import org.scalatest.Suite

class LetterGradeSuite extends Suite {
  def testIntInput() {
    assert("A" === LetterGradeWithGuard.letterGrade(95))
    assert("B" === LetterGradeWithGuard.letterGrade(85))
    assert("C" === LetterGradeWithGuard.letterGrade(75))
    assert("D" === LetterGradeWithGuard.letterGrade(65))
    assert("F" === LetterGradeWithGuard.letterGrade(35))
  }

//  def testFloatInputDoesntWork() {
//    assert("A" === LetterGradeWithGuard.letterGrade(95.5))
//  }

  def testLetterInput() {
    assert("A" == LetterGradeWithGuard.letterGrade("A"))
    assert("A" == LetterGradeWithGuard.letterGrade("a"))
  }

//  def testBadInput() {
//    LetterGrade.letterGrade("BOO!")
//  }

  def testNumericInputOnExtractor() {
    assert("A" === LetterGrade2.letterGrade(95))
    assert("B" === LetterGrade2.letterGrade(85))
    assert("C" === LetterGrade2.letterGrade(75))
    assert("D" === LetterGrade2.letterGrade(65))
    assert("F" === LetterGrade2.letterGrade(35))
  }

  def testLetterInputOnExtractor() {
    assert("A" === LetterGrade2.letterGrade("A"))
    assert("A" === LetterGrade2.letterGrade("a"))
  }

  def testNumericInputOnRangeExtractor() {
    assert("A" === LetterGrade2.letterGrade(95))
  }

}

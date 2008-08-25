object LetterGradeWithGuard {
  val VALID_GRADES = Set("A", "B", "C", "D", "F")
  def letterGrade(value: Any) : String = value match {
    case x:Int if (90 to 100).contains(x) => "A"
    case x:Int if (80 to 90).contains(x) => "B"
    case x:Int if (70 to 80).contains(x) => "C"
    case x:Int if (60 to 70).contains(x) => "D"
    case x:Int if (0 to 60).contains(x) => "F"
    case x:String if VALID_GRADES(x.toUpperCase) => x.toUpperCase()
  }
}

object NumericA {
  def unapply(value: Int): Option[String] = {
    if (90 <= value && value <= 100) Some("A") else None
  }
}

object NumericB {
  def unapply(value: Int): Option[String] = {
    if (80 <= value && value < 90) Some("B") else None
  }
}

object NumericC {
  def unapply(value: Int): Option[String] = {
    if (70 <= value && value < 80) Some("C") else None
  }
}

object NumericD {
  def unapply(value: Int): Option[String] = {
    if (60 <= value && value < 70) Some("D") else None
  }
}

object NumericF {
  def unapply(value: Int): Option[String] = {
    if (0 <= value && value < 60) Some("F") else None
  }
}

object LetterGrade {
  def unapply(value: String): Option[String] = {
    if (LetterGradeWithGuard.VALID_GRADES(value.toUpperCase)) Some(value.toUpperCase) else None  
  }
}

object LetterGrade2 {
  def letterGrade(value: Any) : String = value match {
    case NumericA(value) => "A"
    case NumericB(value) => "B"
    case NumericC(value) => "C"
    case NumericD(value) => "D"
    case NumericF(value) => "F"
    case LetterGrade(value) => value
  }
}

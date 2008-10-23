def letterGrade(value: Any) : String = value match {
  case NumericA(value) => "A"
  case NumericB(value) => "B"
  case NumericC(value) => "C"
  case NumericD(value) => "D"
  case NumericF(value) => "F"
  case LetterGrade(value) => value
}
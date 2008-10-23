def letterGrade(val) {
  switch(val) {
    case 90..100: return 'A'
    case 80..<90:  return 'B'
    case 70..<80:  return 'C'
    case 60..<70:  return 'D'
    case 0..<60:   return 'F'
    case ~"[ABCDFabcdf]": return val.toUpperCase()
    default:  throw new IllegalArgumentException("Not a valid grade: $val")
  }
}
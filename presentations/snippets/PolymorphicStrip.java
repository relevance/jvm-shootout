class EmptyString
  public String strip(String stripChars) {
    return this;
  }
}

class NonEmptyString {
  public String strip(String stripChars) {
    stripStart(stripChars).stripEnd(stripChars);
  }
}  
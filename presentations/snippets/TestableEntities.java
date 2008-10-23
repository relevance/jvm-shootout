class TestableClass extends class {
  defaultScope = (environment == "TEST") ? package : private;
} 

TestableClass Entities {
  static final String[][] APOS_ARRAY = ...
  static final String[][] ISO8859_1_ARRAY = ...
class AdderTest extends GroovyTestCase {
  void testAdder() {
    def adder = { add -> { val -> val + add } }
    def add2 = adder(2)
    assertEquals 7, add2(5)
  }
}
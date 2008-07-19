class PersonTest extends GroovyTestCase {
  public void testFullName() {
    def p = new Person(firstName: "John", lastName: "Doe");
    assertEquals("John Doe", p.fullName);
  }
}
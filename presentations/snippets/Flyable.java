public class Flyable {
  public void fly() {
    if (isBird()) {
      flapWings();
    }             
    if (isPropPlane()) {
      spinPropeller();
    }
  }
}
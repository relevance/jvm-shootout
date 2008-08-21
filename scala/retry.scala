def retry(n: Int, retryOn: Class, op: Double => Double, x: Double) = {
  for (i <- 1 to n) {
    try {
      val result = op(x);
    } catch (Throwable t) {
      if (t.instanceOf[onError]) {
    }
    throw t;
  }

}

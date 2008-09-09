import scala.collection.immutable.Map
import java.util.concurrent.atomic.AtomicReference
import java.math.BigInteger
import java.util.concurrent.atomic.AtomicLong

class CachedFactorizer {
  val hits = new AtomicLong()
  val cache = new AtomicReference(2, calculateFactors(2))
  val cacheHits = new AtomicLong()

  def factor(n: Int) = {
    hits.incrementAndGet
    val cached = cache.get
    if (cached._1 == n) {
      cacheHits.incrementAndGet
      cached._2
    } else {
      val factors = calculateFactors(n)
      cache.set(2, factors)
      factors
    }
  }

  def calculateFactors(n: Int) = {
    def doFactor(factors: List[Int],
                 divisor: Int,
                 dividend: Int): List[Int] = {
      if (divisor > Math.sqrt(dividend)) {
        factors + dividend
      } else {
        if (dividend % divisor == 0) {
          doFactor(factors + divisor, 2, dividend / divisor)
        } else {
          doFactor(factors, divisor + 1, dividend)
        }
      }
    }
    doFactor(List(), 2, n)
  }

}


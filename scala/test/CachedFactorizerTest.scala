import org.scalatest.Suite

class CachedFactorizerSuite extends Suite {
  def testCalculateFactors() {
    val cf = new CachedFactorizer();
    assert(List(2,2) == cf.calculateFactors(4))
    assert(List(2, 3, 3, 47, 14593) == cf.calculateFactors(12345678))
  }

  def testFactors() {
    val cf = new CachedFactorizer();
    assert(cf.hits.get === 0)
    assert(cf.cacheHits.get === 0)
    assert(List(2,2) == cf.factor(4))
    assert(cf.hits.get === 1)
    assert(cf.cacheHits.get === 0)
    assert(List(2,2) == cf.factor(4))
    //assert(cf.hits.get === 2)
    //assert(cf.cacheHits.get === 1)
  }

}
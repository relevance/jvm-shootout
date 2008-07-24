# Ruby already has a rational, this implementation is only for comparison
# to the Scala impl. Use the real thing, this class omits details.

def MyRational(n,d=1)
  MyRational.new(n,d)
end

MyRational = Struct.new(:numerator, :denominator) do
  def initialize(n, d=1)
    raise ArgumentError, "0 denonminator" if d == 0
    g = MyRational.gcd(n,d)
    self.numerator = n / g
    self.denominator = d / g
  end

  def +(other)
    other = other.to_my_rational
    MyRational.new(numerator*other.denominator + denominator*other.numerator,
                   denominator * other.denominator)
  end

  def *(other)
    other = other.to_my_rational
    MyRational.new(numerator*other.numerator,
                   denominator * other.denominator)
  end
  
  def coerce(other)
    [MyRational.new(other), self]
  end
  
  def to_s
    "#{numerator}/#{denominator}"
  end
  
  def to_my_rational
    self
  end
  
  private 
  def self.gcd(a, b)
    b == 0 ? a : gcd(b, a %b)
  end
end

class Integer
  def to_my_rational
    MyRational.new(self, 1)
  end
end

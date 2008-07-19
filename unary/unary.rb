require 'test/unit'

# Demonstrates
# * defining infix operators (+ sign)
# * object-oriented case statement
class Unary
  attr_reader :count
  def initialize(count = 0)
    @count = count
  end
  def +(other)
    Unary.new(self.count + case other
      when Integer
      other
      when Unary
      other.count
      else
      raise ArgumentError
    end)
  end
  def to_s
    "1" * count
  end
end


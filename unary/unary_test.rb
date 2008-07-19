require 'test/unit'
require 'unary'

class UnaryTest < Test::Unit::TestCase
  def test_create
    u = Unary.new
    assert_equal "", u.to_s
  end
  
  def test_add_integer
    u = Unary.new
    u += 2
    assert_equal "11", u.to_s
  end
  
  def test_add_unary
    u1 = Unary.new(1)
    u2 = Unary.new(2)
    assert_equal "111", (u1+u2).to_s
  end
end

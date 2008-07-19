require File.join(File.dirname(__FILE__), "../src/person.rb")
require 'test/unit'

class PersonTest < Test::Unit::TestCase
  def test_full_name
    p = Person.new
    p.first_name = "John"
    p.last_name = "Doe"
    assert_equal "John Doe", p.full_name
  end
end

require 'rubygems'
require 'test/spec'
require 'my_rational'

describe "Rational" do
  
  it "should reject 0 denominator" do
    lambda { MyRational(1,0) }.should.raise(ArgumentError)
  end
  
  it "implements a friendly to_s" do
    MyRational(1,2).to_s.should == "1/2"
  end
  
  it "normalizes" do
    MyRational(2,4).to_s.should == "1/2"
  end
  
  it "adds" do
    (MyRational(1,2) + MyRational(1,5)).should == MyRational(7,10)
  end

  it "multiplies" do
    (MyRational(1,2) * MyRational(1,5)).should == MyRational(1,10)
  end
  
  it "coerces param for add" do
    (MyRational(1,2) + 2).should == MyRational(5,2)
  end
  
  it "coerces self for add" do
    (4 + MyRational(1,2)).should == MyRational(9,2)
  end
  
end

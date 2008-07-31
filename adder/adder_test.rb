require 'rubygems'
require 'test/spec'
require 'adder'

describe "An adder" do
  it "should remember the value passed in" do
    a = adder(5)
    a[2].should == 7
  end
end

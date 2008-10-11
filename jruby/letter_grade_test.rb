require 'rubygems'
require 'test/spec'
require 'letter_grade'

describe "letter_grade" do
  it "90..100 is an A" do
    letter_grade(90).should == 'A'
  end
  it "80...90 is a B" do
    letter_grade(89).should == 'B'
  end
  it "70...80 is a C" do
    letter_grade(79).should == 'C'
  end
  it "60...70 is a D" do
    letter_grade(69).should == 'D'
  end
  it "0...60 is an F" do
    letter_grade(59).should == 'F'
  end
  %W{ A B C D F}.each do |ltr|
    it "#{ltr} is a #{ltr}" do
      letter_grade(ltr).should == ltr
    end
  end
end

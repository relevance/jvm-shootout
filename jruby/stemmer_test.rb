require 'rubygems'
require 'test/spec'
require 'stemmer'

describe "Stemmer" do

  describe "construction" do
    it "tracks a word and an index" do
      s = Stemmer.new("hello")
      s.word.should == "hello"
      s.index.should == 4
    end
    
    it "handles empty string gracefully" do
      s = Stemmer.new("")
      s.word.should == ""
      s.index.should == -1
    end
  end
  
  it "returns subword up to index" do
    s = Stemmer.new("hello")
    s.subword.should == "hello"
    s.index = 0
    s.subword.should == "h"
  end
  
  describe "index_char" do
    it "returns char at index" do
      s = Stemmer.new("robot")
      s.index_char.should == ?t
      s.index = 2
      s.index_char.should == ?b
    end

    it "index_char returns nil for empty string" do
      s = Stemmer.new("")
      s.index_char.should == nil
    end
  end
  
  it "can pop one character" do
    s = Stemmer.new("hello")
    s2 = s.pop_word
    s2.word.should == "hell"
    s2.index.should == 3
  end
  
  it "can pop by a predicate" do
    s = Stemmer.new("ball")
    s2 = s.pop_by { |x| x == ?l }
    s2.word.should == "ba"
    s2.index.should == 1
  end
  
  it "pop_by ends recursion" do
    s = Stemmer.new("ball")
    s2 = s.pop_by { |x| true}
    s2.word.should == ""
  end

  describe "Fixnum additions" do
    it "knows its vowel letters" do
      ?a.vowel_letter?.should == true
      ?b.vowel_letter?.should == false
    end
  end
end

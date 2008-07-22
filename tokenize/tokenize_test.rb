require 'rubygems'
require 'test/spec'
require 'tokenize'

describe "Tokenize" do
  it "splits words" do
    Tokenize["the quick brown fox"].should == %w{the quick brown fox}
  end
  
  it "downcases all words" do
    Tokenize["THE quicK Brown fOx"].should == %w{the quick brown fox}
  end
  
  it "respects default stop words" do
    Tokenize["THE quicK Brown fOx", true].should == %w{ quick brown fox}    
  end
  
  it "respects custom stop words" do
    Tokenize["THE quicK Brown fOx", %w{ quick }].should == %w{ the brown fox}        
  end
end

require 'set'

class Stemmer
  attr_accessor :word, :index
  def initialize(word, index = word.size-1)
    self.word = word
    self.index = index
  end
  
  def index=(value)
    @index = [value, word.size-1].min
  end
  
  def subword
    @word[0..index]
  end
  
  def index_char
    @word[index]
  end
  
  def pop_word
    Stemmer.new(@word[0..-2],index)
  end
  
  def pop_by(&blk)
    index_char && blk[index_char] ? pop_word.pop_by(&blk) : self
  end
  
  def consonant?(i = index)
   
  end
  
end

class Fixnum
  class << self
    attr_reader :vowel_letters
  end
  @vowel_letters = Set.new([?a, ?e, ?i, ?o, ?u])
  def vowel_letter?
    Fixnum.vowel_letters.member?(self)
  end
end

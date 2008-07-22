module Tokenize
  def self.default_stop_words
    %w{ a in that for was is it the of and to}
  end
  def self.[](str, stop = [])
    stop_words = (stop == true) ? default_stop_words : stop
    str.split(/[^\w]/).map{ |s| s.downcase} - stop_words
  end
end

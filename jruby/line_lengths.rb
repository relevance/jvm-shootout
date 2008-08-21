width_of_length = lambda { |s| s.length.to_s.length }
if ARGV.empty?
  puts "Please enter filename"
else
  lines = File.readlines(ARGV[0])
  widths = lines.map(&width_of_length)
  max_width = widths.max
  lines.each do |line|
    padding = " " * (max_width - width_of_length[line])
    puts "#{padding}#{line.length} #{line}"
  end
end

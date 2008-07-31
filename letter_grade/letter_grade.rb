def letter_grade(val)
  case val
    when 90..100: 'A'
    when 80..90:  'B'
    when 70..80:  'C'
    when 60..70:  'D'
    when 0..60:   'F'
    when /[ABCDF]/: val.upcase
    else raise "Not a valid grade: #{val}"
  end
end

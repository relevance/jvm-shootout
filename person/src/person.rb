class Person
  attr_accessor :first_name, :last_name
  def full_name
    "#{first_name} #{last_name}"
  end
end

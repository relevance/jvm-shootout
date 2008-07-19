(defstruct person :first-name :last-name)
(defn full-name [person]
  (str
   (:first-name person) 
   " "
   (:last-name person)))
(defn letter-grade [grade]
  (cond 
   (in grade 90 100) "A"
   (in grade 80 90) "B"
   (in grade 70 80) "C"
   (in grade 60 70) "D"
   (in grade 0 60) "F"
   (re-find #"[ABCDFabcdf]" grade) (.toUpperCase grade)))
(. clojure.lang.RT (loadResourceScript "clojure/contrib/lib/lib.clj"))
(refer 'clojure.contrib.lib)
(load-libs 'clojure.contrib.pred.pred)
(refer 'clojure.contrib.pred)

(defn in [grade low high]
  (and (number? grade) (<= low grade high)))

(defn letter-grade [grade]
  (cond 
   (in grade 90 100) "A"
   (in grade 80 90) "B"
   (in grade 70 80) "C"
   (in grade 60 70) "D"
   (in grade 0 60) "F"
   (re-find #"[ABCDFabcdf]" grade) (.toUpperCase grade)))



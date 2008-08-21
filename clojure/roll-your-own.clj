(defn most [& rest]
  (> (* 2 (count (filter identity rest)))
     (count rest)))

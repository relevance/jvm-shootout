(defmacro debug
  [expr]
  `(let [value# ~expr]
     (println '~expr "=>" value#)
     (flush)
     value#))
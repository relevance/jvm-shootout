(defn adder [add]
  (let [y add]
    (fn [x] (+ x y)))) 
(defn sum [l r] {:TreeType :Sum :l l :r r})
(defn variable [name] {:TreeType :Var :name name})
(defn const [i] {:TreeType :Const :i i})

; could also name and reuse discriminator function from tree.clj
(defn evaluate [tree, env]
  (let [tt (:TreeType tree)]
    (cond 
     (= tt :Sum) (+ (evaluate (:l tree) env) (evaluate (:r tree) env))
     (= tt :Var) ((:name tree) env)
     (= tt :Const) (:i tree))))

(defn derive [tree, str]
  (let [tt (:TreeType tree)]
    (cond
     (= tt :Sum) (sum (derive (:l tree) str) (derive (:r tree) str))
     (and (= tt :Var) (= (:name tree) str)) (const 1)
     true (const 0))))

(defn simplify [tree]
  (let [tt (:TreeType tree)]
    (cond
     (= tt :Sum) (+ (simplify (:l tree)) (simplify (:r tree)))
     (= tt :Const) (:i tree)
     true "woot")))

(def *tmp* (sum (sum (variable :x) (variable :x))
		(sum (const 7) (variable :y))))

(println "Evaluation with x=5, y=7: " (evaluate *tmp* {:x 5 :y 7}))
(println "Derviative wrt x: " (simplify (derive *tmp* :x)))
(println "Derviative wrt y: " (simplify (derive *tmp* :y)))

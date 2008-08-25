(defmulti evaluate (fn [tree, env] (:TreeType tree)))
(defn sum [l r] {:TreeType :Sum :l l :r r})
(defn variable [name] {:TreeType :Var :name name})
(defn const [i] {:TreeType :Const :i i})

(defmethod evaluate :Sum [tree, env]
  (+ (evaluate (:l tree) env) (evaluate (:r tree) env)))
(defmethod evaluate :Var [tree, env]
  ((:name tree) env))
(defmethod evaluate :Const [tree,env]
  (:i tree))

(def *tmp* (sum (sum (variable :x) (variable :x))
		(sum (const 7) (variable :y))))

(println "Evaluation with x=5, y=7: " (evaluate *tmp* {:x 5 :y 7}))


(defmulti pretty-print (fn [item] (:type item)))
(defmethod pretty-print :int-exp [exp] (print (:e exp)))
(defmethod pretty-print :add-exp [exp] 
  (print (:e1 exp) " + " (:e2 exp)))
(defmethod pretty-print :default [exp] (print exp))
					  
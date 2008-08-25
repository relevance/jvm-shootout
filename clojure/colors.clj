(defstruct color :red :green :blue)

(defn red [v] (struct color v 0 0))
(defn green [v] (struct color 0 v 0))
(defn blue [v] (struct color 0 0 v))

(defn keys-with-value-matching [map test-fn]
     (for [pair (map identity map) :when (test-fn (last pair))] 
       (first pair)))

(defn basic-colors-in [color]
  (keys-with-value-matching color (comp not zero?)))

(defmulti color-string basic-colors-in)
(defmethod color-string [:red] [color] (str "Red: " (:red color)))
(defmethod color-string [:green] [color] (str "Green: " (:green color)))
(defmethod color-string [:blue] [color] (str "Blue: " (:blue color)))
(defmethod color-string :default [color] 
  (str "Red: " (:red color) ", Green: " (:green color) ", Blue: " (:blue color)))



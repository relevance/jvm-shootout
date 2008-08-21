(defstruct color :red :green :blue)

(defn primary-colors-in [color]
  (apply vector (map first (filter (fn [pair] (not (zero? (last pair)))) (map identity color)))))

(defn red [v] (struct color v 0 0))
(defn green [v] (struct color 0 v 0))
(defn blue [v] (struct color 0 0 v))

(defmulti color-string primary-colors-in)
(defmethod color-string [:red] [color] (str "Red: " (:red color)))
(defmethod color-string [:green] [color] (str "Green: " (:green color)))
(defmethod color-string [:blue] [color] (str "Blue: " (:blue color)))
(defmethod color-string :default [color] 
  (str "Red: " (:red color) ", Green: " (:green color) ", Blue: " (:blue color)))
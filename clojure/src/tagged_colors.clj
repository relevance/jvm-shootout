(defstruct color :red :green :blue)

(defn color-class [name r g b]
 (assoc (struct color r g b) :tag name))

(defn red [v] (color-class :red  v 0 0))
(defn green [v] (color-class :green 0 v 0))
(defn blue [v] (color-class :blue 0 0 v))
(defmulti color-string :tag)
(defmethod color-string :red [c] (str "Red: " (:red c)))
(defmethod color-string :green [c] (str "Green: " (:green c)))
(defmethod color-string :blue [c] (str "Blue: " (:blue c)))
(defmethod color-string :default [{:keys [red green blue]}]
   (str "Color, R: " red ", G: " green ", B: " blue))
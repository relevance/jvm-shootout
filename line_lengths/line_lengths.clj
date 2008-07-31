(defn width-of-length [str]
  (.. str (length) (toString) (length)))
(defn read-lines [file]
  (re-seq #"[^\n]+" (slurp file)))
(defn padding [size]
  (apply str (replicate size " ")))
(defn print-lines [file]
  (let [lines (read-lines file)
 	      widths (map width-of-length lines)
	      max-width (reduce max widths)]
   (doseq line lines
     (println 
      (padding (- max-width (width-of-length line)))
      (. line (length)) 
      " " 
      line))))

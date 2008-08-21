; Clojure
(defn blank? [x] 
  (cond (string? x) (= (.length x) 0)
	(nil? x) true
        (throw (new Exception "time to support some new types"))))
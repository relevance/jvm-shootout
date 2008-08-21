(in-ns 'porter)
(clojure/refer 'clojure)

(defstruct stemmer :word :index)

(defn make-stemmer 
  "Returns a stemmer structure for the given word"
  [word]
  (struct stemmer (vec word) (dec (count word))))

(defn reset-index
  "Returns a new stemmer with the :index set to the last index"
  [word-vec]
  (struct stemmer word-vec (dec (count word-vec))))

(defn get-index
  "Gets a valid value for index"
  [stemmer]
  (if-let j (:index stemmer)
    (min j (dec (count (:word stemmer))))
    (dec (count (:word stemmer)))))

(defn subword
  "Returns the word up to the index"
  [stemmer]
  (let [b (:word stemmer), j (inc (get-index stemmer))]
    (if (< j (count b))
      (subvec b 0 j)
      b)))

(defn index-char
  "Char at index"
  [stemmer]
  (nth (:word stemmer) (get-index stemmer)))

(defn pop-word
  "Returns stemmer with one character popped off"
  [stemmer]
  (assoc stemmer :word (pop (:word stemmer))))

(defn pop-stemmer-on
  [predicate stemmer]
  (if (and (seq (:word stemmer)) (predicate stemmer))
    (recur predicate (pop-word stemmer))
    stemmer))

(def vowel-letter? #{\a \e \i \o \u})

(defn consonant?
  "Is ith character a consonant? i defaults to index"
  ([stemmer]
     (consonant? stemmer (get-index stemmer)))
  ([stemmer i]
     (let [c (nth (:word stemmer) i)]
       (cond (vowel-letter? c) false
	     (= c \y) (if (zero? i)
			true
			(not (consonant? stemmer (dec i))))
	     (:else true)))))
	     
(def vowel? (complement consonant?))

(defn vowel-in-stem?
  "True if any vowel before index"
  [stemmer]
  (let [j (get-index stemmer)]
    (loop [i 0]
      (cond (> i j) false
	    (consonant? stemmer i) (recur (inc i))
	    :else true))))

(defn double-c?
  "true if i/index is on last of double consonant"
  ([stemmer]
     (double-c? stemmer (get-index stemmer)))
  ([stemmer j]
     (and (>= j 1)
	  (= (nth (:word stemmer) j)
	     (nth (:word stemmer) (dec j)))
	  (consonant? stemmer j))))
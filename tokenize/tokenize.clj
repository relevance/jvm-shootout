;; From the tokenization tutorial at http://writingcoding.blogspot.com/2008/06/clojure-series-table-of-contents.html

(in-ns 'word)
(clojure/refer 'clojure)

(def stop-words
  #{"a" "in" "that" "for" "was" "is" "it" "the" "of" "and" "to"})
(def token-regex #"\\w+")

(defn to-lower-case [str]
  (. str (toLowerCase)))
(defn tokenize-str 
  ([input-string]
     (map to-lower-case (re-seq token-regex input-string)))
  ([input-string stop-word?]
     (filter (complement stop-word?) (tokenize-str input-string))))



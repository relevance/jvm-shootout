(. clojure.lang.RT (loadResourceScript "clojure/contrib/lib/lib.clj"))
(refer 'clojure.contrib.lib)
(load-libs 'clojure.contrib.test-is.test-is)
(refer 'clojure.contrib.test-is)

(deftest letter-grade
  (is (= "A" (letter-grade "A")))
  (is (= "A" (letter-grade 95)))
  (is (= "B" (letter-grade 85)))
  (is (= "C" (letter-grade 75)))
  (is (= "D" (letter-grade 65)))
  (is (= "F" (letter-grade 35)))
)

(run-tests)


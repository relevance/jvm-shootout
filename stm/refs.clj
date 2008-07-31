; from http://clojure.org/refs
(import '(java.util.concurrent Executors LinkedBlockingQueue))
(defn my-pmap [f coll]
  (let [nthreads (.. Runtime (getRuntime)
                     (availableProcessors))
        exec (. Executors (newFixedThreadPool nthreads))
        todo (ref (seq coll))
        out (ref 0)
        q (new LinkedBlockingQueue)
        produce #(let [job (dosync
                            (when @todo
                              (let [item (first @todo)]
                                (alter todo rest)
                                (commute out inc)
                                (list item))))]
                   (when job
                     (. q (put (f (first job))))
                     (recur)))
        tasks (doseq dnu (map #(. exec (submit %))
                              (replicate nthreads produce)))
        consume (fn thisfn []
                    (if (dosync (and (or @todo (pos? @out))
                                     (commute out dec)))
                      (fnseq (. q (take)) thisfn)
                      (do
                        (. exec (shutdown))
                        (doseq x tasks)
                        nil)))]
    (consume)))

;; timing
;; (defn ack [m n]
;;   (cond
;;    (zero? m) (inc n)
;;    (zero? n) (recur (dec m) 1)
;;    (pos? n) (recur (dec m) (ack m (dec n)))))
;; user=> (time (reduce + (map (partial ack 3) (replicate 1000 6))))
;; user=> "Elapsed time: 14939.482 msecs"
;; 509000
;; user=> (time (reduce + (my-pmap (partial ack 3) (replicate 1000 6))))
;; "Elapsed time: 6138.683 msecs"
;; 509000
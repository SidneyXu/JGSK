;when
(when true
  (println "one")
  (println "two"))

(when-let [pos-nums (filter pos? [-1 -2 1 2])]
  pos-nums
  (println "one")
  (println "two"))

;case
(defn case-test-1
  [n]
  (case n
    1 "n is 1"
    2 "n is 2"
    "n is other"))
(println (case-test-1 1))
(println (case-test-1 2))
(println (case-test-1 3))

;else
(defn cond-test
  [n]
  (cond
    (= n 1) "n is 1"
    (and (> n 3) (< n 10)) "n is over 3 and under 10"
    :else "n is other"))

(println (cond-test 1))

;condp
(defn condp-test-2
  [n]
  (condp contains? n
    [1 2 3] "n is either 1 or 2 or 3"
    "n is not 1 or 2 or 3"))

(println (condp-test-2 2))


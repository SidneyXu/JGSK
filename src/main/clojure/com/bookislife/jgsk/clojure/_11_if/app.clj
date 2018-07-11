;If
(def x 1)
(def y 2)
(if (= 0 (+ x y))
  (println "x+y==3")
  (println "x+y!=3"))

;If-do
(if false
  (do
    (println "when true-1")
    (println "when true-2"))
  (do
    (println "when false-1")
    (println "when false-2")))

;If-let
(if-let [sum (= 30 (+ 10 20))]
  (println sum)
  (println "sum not equal to 30"))
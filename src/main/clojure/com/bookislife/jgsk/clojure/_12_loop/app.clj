;for
(for [x [1 2 3]] (x))

;doseq
(doseq [x [1 2 3]] (println (str "Repeat doseq " x)))

(doseq [n1 [1 2]
        n2 [4 5]]
  (println (+ n1 n2)))

;loop
(loop [x 10]
  (when (> x 1)
    (println (str "Repeat loop" x))
    (recur (- x 2))))
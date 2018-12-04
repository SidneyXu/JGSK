;Sequences
;you can apply the same functions to any types of collections without worrying about what types of collections that you are dealing with.
;apply vector
(println (map inc [1 2 3]))

;apply list
(println (map inc `(1 2 3)))

;apply map
(map println {:a 1 :b 2 :c 3})

;Function
;map
(map inc [1 2 3])
(map (fn [x] (+ x 1)) '(1 2 3))

;reduce
(reduce + [1 2 3 4])
;default value
(reduce + -10 [1 2 3 4])

;convert one type to other
(into [] `(1 2 3))
(into #{} [1 2 3])
(reduce conj #{} [1 2 3])


;Range
(range 5 10)

(repeatedly 5 (fn [] (println "hi!")))


(take 5 (range 0 100))

(take-while neg? [-3 -2 -1 0 1 2 3])
(drop 5 (range 0 10))
(drop-while neg? [-3 -2 -1 0 1 2 3])

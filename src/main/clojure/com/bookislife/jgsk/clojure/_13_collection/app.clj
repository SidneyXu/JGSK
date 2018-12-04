;Vecotr
;Immutable
;Define
(def vec ["Groovy" "Java" "Scala"])
(def vec2 (vector "Groovy" "Java" "Scala"))
(println vec)

;Access Elements
(println (nth vec 0)) ;Groovy
(println (nth vec 10 "Default Value")) ;Default Value
(println (get vec 1)) ;Java
(println (get vec 10 "Default Value")) ;Default Value

;Concat
(println (concat vec ["Kotlin" "Clojure"]))

;Length
(println (count vec))

;Loop
(doseq [it vec] (println it))


;List
(def langs (list "Groovy" "Java" "Scala"))

;Set
;Immutable
;Define
(def nums #{1, 2, 3})
(println nums)

(println (set (concat nums [1 5])))

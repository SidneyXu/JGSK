;Operators
(println (+ 3 3)) ;6
(println (/ 10 3)) ;10/3
(println (/ 10 3.0)) ;3.33

(def i 1)
(def i+1 (inc i))
(println i+1) ;2

;Call Methods
(defn add [x,y]
  (+ x y))
(println (add 1 2)) ;3

;Equals
(println (= 1 1)) ;true
(println (= "x" "x")) ;true
(println (identical? (String. "x") "x")) ;false

(println (not= 1 1)) ;false


; Data Types
(def x 2)
(println x)

(def x "foo")
(println x)

; BigDecimal
(println (- 2 1.8))
(println (- (bigdec 2) (bigdec 1.8))) ;0.2

; Boolean
(println (boolean nil)) ;false
(println (boolean 0)) ;true
(println (boolean 1)) ;true

; Type Inference
(println (type x)) ;String
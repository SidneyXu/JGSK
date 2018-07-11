;Variable
;def
;access anywhere
(def variable "foo")
(println variable)

;override value
(def variable "bar")
(println variable)

(def date (new java.util.Date))
(println date)

;Constant
(def *constant* "foo")
(println *constant*)
(def *constant* "bar")
(println *constant*)

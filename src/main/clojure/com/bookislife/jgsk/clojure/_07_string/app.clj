;Literals
(def s "Hello World")

;Multiple Lines
(def text "1, 2, 3
one, two, three
\"x, \"y\", \"z\"")

(println s)
(println text)

;Concatenate
(def ret (str "x" "y"))
(println ret) ;xy

;Template
(def salary 100.1)
(println (format "name=%s has %.5f"
           "Peter" 5.0))  ;name=Peter has 5.00000
;definde
(defmacro unless [test then]
  "Evaluates then when test evaluates to be falsey"
  (list 'if (list 'not test)
    then))

(macroexpand '(unless false (println "hi")))


;Quote
;return the expression without execute it
(quote (+ 1 2))
;same as above
'(+ 1 2)


'(dec (inc 1))
`(dec (inc 1))


'(+ 1 ~(inc 1))
`(+ 1 ~(inc 1))

`(+ ~(list 1 2 3))
`(+ ~@(list 1 2 3))
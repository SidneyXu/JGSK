(conj (conj (conj [] 1) 2) 3)

;not use threads as its name
;-> is called thread-first macro
(-> []
  (conj 1)
  (conj 2)
  (conj 3))


;->> is called thread-last macro. It’s last because it’s passing down the evaluation of former forms to the last argument of preceding forms.
(->> ["japan" "china" "korea"]
  (map clojure.string/upper-case)
  (map #(str "Hello " %)))




;delay
(def later (do [] (prn "Adding") (+ 1 2)))

(def later (delay (do [] (prn "Adding") (+ 1 2))))


;The difference from a plain function is that delay is only evaluated once and caches the result
(force later)
(later)


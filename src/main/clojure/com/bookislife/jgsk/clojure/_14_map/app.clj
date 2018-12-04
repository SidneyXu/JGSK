;Map
;Immutable
;Define
(def person {:name "Peter" "age" 12 "national" "USA"})

;Get
(println (get person :name))
(println (get person "age"))

;New Map
(println (merge person {"height" 180}))
(println (assoc person "weight" 69))

;Key and Value
(println keys person)
(println vals person)

;Length
(println (count person))

;Loop
(doseq [entry person] (println (val entry)))

;Remove
(println (dissoc person :name "age"))
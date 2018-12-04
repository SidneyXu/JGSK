;refs
;define
(def my-ref (ref 0))

;obtain
(deref my-ref)
@my-ref

;do-sync
;The update of refs must be done inside dosync block. dosync is telling Clojure where the transaction update starts from. To set a ref to a new value, use ref-set.
(deref my-ref)
(dosync
  (ref-set my-ref 1)
  (ref-set my-ref 2))
@my-ref

(ref-set my-ref 3)

;alter
(def my-ref (ref 0))
(dosync
  (alter my-ref
    (fn [current_ref]
      (inc current_ref))))

@my-ref
(dosync
  (alter my-ref
    (fn [_] "not int")))

;transition
(def user (ref {}))
(dosync
  (alter user merge {:name "Kim"})
  (throw (Exception. "something wrong happens!"))
  (alter user merge {:age 32}))
;As you see, the user-record ref is still empty. This is because alter inside dosync doesn’t update the ref until getting out of dosync block successfully.


(future
  (dosync
    (alter my-ref inc)
    (Thread/sleep 5000)))

(println @my-ref)
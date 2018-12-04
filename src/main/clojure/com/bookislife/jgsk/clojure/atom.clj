;atom is used to manager state, mutable
;create atom with value
(def atom-str (atom "hello"))
(def atom-int (atom 53))

;obtain value
(deref atom-int)
@atom-int

;reset
(reset! atom-int 35)


;use function update atom
(swap! atom-int
  (fn [current-atom]
    (inc current-atom)))

(swap! atom-int
  (fn [_]
    "not int"))

(defn multiple-by
  [current-atom num]
  (* current-atom num))

(swap! atom-int multiple-by 10)

;atom is thread safe
(def x 0)
(repeatedly 10
  (fn [] (def x (inc x))))

(repeatedly 10
  (fn [] (future (def x (inc x)))))

(def x (atom 0))
(repeatedly 10
  (fn [] (future (swap! x inc))))




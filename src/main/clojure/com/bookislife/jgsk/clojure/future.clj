(do
  (Thread/sleep 3000)
  (println "hello"))


(do
  (future
    (Thread/sleep 3000)
    (println "after sleep"))
  (println "hello"))


(let [future-val (future (inc 1))]
  (println future-val))

;deref obtain the return value
(let [future-val (future (inc 1))]
  (println (deref future-val)))

;@ also can
(let [future-val (future (inc 1))]
  (println @future-val))

@(future (Thread/sleep 3000) "returned!")




(let [sleep-and-wait
      (map (fn [time]
             (future
               (Thread/sleep time)
               (println (str "slept " time " sec"))))
        [1000 2000])]
  (doall (map deref sleep-and-wait))
  (println "done"))


;check if is done
(def my-future (future (Thread/sleep 5000)))
(repeatedly 6
  (fn []
    (println (realized? my-future))
    (Thread/sleep 1000)))
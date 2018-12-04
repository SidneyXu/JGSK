(def my-promise (promise))

(def listen-and-callback (fn []
                           (println "Start listening...")
                           (future (println "Callback fired: " @my-promise))))


(defn do-time-consuming-job []
  (Thread/sleep 5000)
  (deliver my-promise "delivered value"))


(listen-and-callback) (do-time-consuming-job)



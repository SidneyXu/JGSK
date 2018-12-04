;Define
(defn add [x,y] (+ x y))
(def add2 (fn [x] (+ x 2)))

;Call
(println (add 2 3))
(println (add2 10))

;Varargs
(defn sum [& num] (apply + num))
(println (sum 1 2 3 4 5))

;Document
(defn add10
  "add 10 to passed value"
  [x]
  (+ x 10))

;Meta Data
(defn say-hello
  "Takes name argument and say hello to the name"
  {:added "1.0"
   :static true}
  [name]
  (println (str "Hello, " name)))

;meta need var object not value ,say-hello passed to var first
(println (meta (var say-hello)))
(println (get (meta (var say-hello)) :added))
(println (get (meta (var say-hello)) :doc))
(println (meta #'say-hello))

;Anonymous
(fn [] (println "Hello world"))

;#() is shortcut for fn
(println (#(+ 1 1)))

;Placeholder
(let [plus-numbers #(+ 1 %1 %2 %3)]
  (plus-numbers 10 20 30))
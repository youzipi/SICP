(ns ch1.lambda)

;Σ
;
(defn sum
  "docstring"
  [term, a, next, b]
  (if (> a b)
    0
    (+
      (term a)
      (sum term
           (next a)
           next
           b
           )
      )
    )
  )


(defn me
  "docstring"
  [a]
  a
  )

(defn add_one
  "docstring"
  [a]
  (+ a 1)
  )


(println (sum me, 0, add_one, 10))
(println (sum
           (fn [x] x),
           0,
           (fn [x] (+ x 1)),
           10)
         )
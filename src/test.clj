(defn abs
  "docstring"
  [x]
  (if (< x 0)
    (- 0 x)
    x))

(println (abs -25))
(println (abs 23))

(ns ch1.1-17)

; result = b*n
;a_n + b_n = a_0 + b_0
;
;n = 0:
;

(defn multiply
  "docstring"
  [b, n]
  (if (= n 0)
    0
    (+ b (multiply b (- n 1)))
    )
  )



(defn double
  "docstring"
  [x]
  (* x 2))

(defn halve
  "docstring"
  [x]
  (/ x 2))

(defn fast-multiply-iter
  "docstring"
  [a, b, n]
  (println a, b, n)
  (cond
    (= n 0)
      a
    (= 0 (rem n 2))
      (fast-multiply-iter (double a), b, (halve n))
    (= 1 (rem n 2))
      (fast-multiply-iter (+ a b) b, (- n 1))
    )
  )

(defn fast-multiply
  "docstring"
  [b, n]
  (fast-multiply-iter b, b, (- n 1))
  )

(println (double 3))
(println (halve 3))
(println (fast-multiply 3 5))

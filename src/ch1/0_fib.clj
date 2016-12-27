(ns ch1.0-fib)

(defn fib-iter [a b count]
  (if (= count 0)
    b
    (fib-iter (+ a b) a (- count 1))
    )
  )

(defn fib
  "docstring"
  [n]
  (fib-iter 1, 0, n))


(println (fib 10))
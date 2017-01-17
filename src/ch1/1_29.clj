(ns ch1.1-29)





(defn fun
  "docstring"
  [f, a, b, n]
  ;
  ; h = (b - a) / n
  ; x_k = a + k * h
  ;
  (let [h (/ (- b a) n)]
    (letfn [
            ;x_k
            (x_k [k]
              (+ a
                 (* k h))
              ),
            ;y_k
            (y_k [k]
              (f (x_k k))
              ),

            (ret [k]
              (cond
                (= k 0) (y_k k)
                (= k n) (+
                          (y_k k)
                          (ret (- k 1))
                          )
                (= 0 (rem k 2)) (+
                                  (* 2 (y_k k))
                                  (ret (- k 1))
                                  )
                (= 1 (rem k 2)) (+
                                  (* 4 (y_k k))
                                  (ret (- k 1))
                                  ))
              )
            ]
      (* (/ h 3) (ret n))
      ))
  )




;
(println (fun (fn [x] (* x x)), 1.0, 2.0, 1000))
(println (fun (fn [x] (* x x)), 0, 1.0, 1000))
(println (fun (fn [x] (* 2 x)), 1.0, 2.0, 1000))
(println (fun (fn [x] (* 2 x)), 0, 1.0, 1000))
(println (fun (fn [x] (* x x -1)), -1000.0, 1000.0, 1000))

(println (fun (fn [x] (* x x x)), 0, 1, 8))
(println (fun (fn [x] (* x x x)), 0, 1, 2))


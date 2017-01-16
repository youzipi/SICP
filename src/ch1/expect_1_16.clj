(ns ch1.expect_1_16)

; 1.2.4 求幂
; b^n
; 定义：
; n = 0: expt(b,0) = 1
; n > 0: expt(b,n) = b * expt(b n-1)
;
; 转化为迭代的方式：
; 单次计算需要 b,前一次计算的结果，还需要计算的次数
; expt-iter(b,product_[n-1],n)
;   product_n-1 = b * product_[n-2]


(defn expt-iter [product b n]
  (if (= n 0)
    product
    (expt-iter
      (* product b)
      b
      (- n 1)
      )
    )
  )

(defn expt
  "docstring"
  [b, n]
  (expt-iter 1, b, n))

(println (expt 3 4))


(defn fast1-expt-iter [product a b n]
  (if (not (> n 1))
    ; n <= 1,则遍历结束，返回 product*a
    (* product a)
    (fast1-expt-iter
      (* product product)
      (if (= 0 (rem n 2))
        ; n为偶数,则a不变，若n为奇数，则 a *= b
        a
        (* a b)
        )
      b
      (quot n 2)
      )
    )
  )


(defn fast-expt-iter [product a b n]
  (cond
    (= n 0) (/ (* product a) b)
    ; n <= 1,则遍历结束，返回 product*a
    (= 0 (rem n 2)) (fast-expt-iter (* product product), a, b, (/ n 2))
    (= 1 (rem n 2)) (fast-expt-iter product, (* a b), b, (- n 1))
    )
  )

(defn fast-expt
  "docstring"
  [b, n]
  (fast-expt-iter b, 1, b, n))

(println (fast-expt 3, 4))
(println (fast-expt 3, 3))
(println (fast-expt 3, 2))
(println (fast-expt 3, 1))
(println (fast-expt 3, 0))
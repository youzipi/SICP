(ns ch1.pow)

; 求幂
; b^n
; 定义：
; n = 0: pow(b,0) = 1
; n > 0: pow(b,n) = b * pow(b n-1)
;
; 转化为迭代的方式：
; 单次计算需要 b,前一次计算的结果，还需要计算的次数
; pow-iter(b,product_[n-1],n)
;   product_n-1 = b * product_[n-2]


(defn pow-iter [product b n]
  (if (= n 0)
    product
    (pow-iter
      (* product b)
      b
      (- n 1)
      )))

(defn pow
  "docstring"
  [b, n]
  (pow-iter 1, b, n))

(println (pow 3 4))
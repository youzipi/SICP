(ns ch1.1-11)
(comment "
if n < 3:f(n) = n
if n >= 3: f(n) = f(n-1) + 2f(n-2) + 3f(n-3)

")


(defn f
  "docstring"
  [n]
  (if (< n 3)
    n
    (+
      (* 1 (f (- n 1)))
      (* 2 (f (- n 2)))
      (* 3 (f (- n 3)))
      )
    )
  )

;迭代
; 自底向上
; 把下一阶段需要的所有状态传出去
; f(n) = f(n-1) + 2f(n-2)+ 3f(n-3)
; f(a,b,c,n) =

(defn f-iter [a b c count]
  (if (< count 3)
    a
    (f-iter 
      (+ a (* 2 b) (* 3 c))
      a
      b
      (- count 1)
      )
    ))

(defn f1
  "docstring"
  [n]
  (f-iter 2 1 0 n))



(println (f 10))
(println (f1 10))
; 1892


;更好理解的逻辑
;a,b,c 分别表示 f(i+2),f(i+1),f(i)
; i 从 0 开始，逼近 n

(defn f2-iter [a b c i n]
  (if (= i n)
    c
    (f2-iter 
      (+ a (* 2 b) (* 3 c))
      a
      b
      (+ i 1)
      n
      )
    ))

(defn f2
  "docstring"
  [n]
  (f2-iter 2 1 0 0 n))

(println (f2 10))
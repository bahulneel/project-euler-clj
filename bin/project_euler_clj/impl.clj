(ns project-euler-clj.impl)

(defn lazy-fib
  "Return a lazy Fibonacci sequence"
  [first next]
  (cons
    first
    (lazy-seq (lazy-fib next (+ first next)))))
    
(defn gpf-filter
  [cand]
  (let [[n f] cand]
    (or (nil? f) (= n f) (> f (Math/sqrt n)))))

(defn gpf-seq
  [n c]
  (let [f (first (filter #(= 0 (rem n %)) (range c n)))]
    (cons
      [n f]
      (lazy-seq (gpf-seq (/ n f) f)))))

(defn gpf
  ([n]
    (gpf n 2))
  ([n c]
    (let [s (gpf-seq n c)
          [n f] (first (filter gpf-filter s))]
      n)))

(defn palindrome?
  ([n]
    (let [s (str n)]
      (= s (apply str (reverse s))))))

(defn products
  [dig]
  (let [max (int (Math/pow 10 dig))
        min (/ max 10)
        numbers (range min max)]
    (for [x numbers y numbers]
      (* x y))))
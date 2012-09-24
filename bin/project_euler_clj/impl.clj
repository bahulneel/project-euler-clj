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

(defn even-multiples
  ([x]
    (even-multiples x 2))
  ([x n]
    (cons
      (* x n)
      (lazy-seq (even-multiples x (+ 2 n))))))

(defn smalest-even-divisible
  ([max]
    (first (smalest-even-divisible (- max 1) (even-multiples max))))
  ([max seq]
    (if (= 1 max)
      seq
      (smalest-even-divisible (- max 1) (filter #(= 0 (rem % max)) seq)))))

(defn sum-squares
  [nums]
  (reduce + (map #(* % %) nums)))

(defn square-sum
 [nums]
 (let [sum (reduce + nums)]
   (* sum sum)))

(defn numbers
  [start]
  (cons
    start
    (lazy-seq (numbers (+ 1 start)))))

(defn not-factor?
  [n factors]
  (empty? (filter zero? (map #(rem n %) factors))))

(defn next-prime
  [start primes]
  (first
    (filter #(not-factor? % primes) (numbers start))))

(defn primes
  ([]
    (primes 2 #{}))
  ([n s]
    (cons
      n
      (let [next-s (conj s n)]
        (lazy-seq (primes (next-prime n next-s) next-s))))))

(defn prod-chars
  ([s]
    (reduce * (map #(- (int %) (int \0)) s))))

(defn pythag-trips
  ([]
    (pythag-trips (numbers 2)))
  ([s]
    (map #(pythag-trips % (numbers (+ 1 %))) s))
  ([a s]
    (map #(pythag-trips a % (Math/sqrt (sum-squares [a %]))) s))
  ([a b c]
    (if (integer? c)
      [a b c]
      nil
      )))

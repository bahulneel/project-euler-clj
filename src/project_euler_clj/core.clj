(ns project-euler-clj.core
  (:use project-euler-clj.impl))

(defn problem1
  "Find the sum of all the multiples of 3 or 5 below 1000."
  ([]
    (problem1 1000))
  ([max]
  (reduce
    +
    (filter
      #(or (= 0 (mod % 3)) (= 0 (mod % 5)))
      (seq (range 1 max))))))

(defn problem2
  "By considering the terms in the Fibonacci sequence whose values
   do not exceed four million, find the sum of the even-valued terms."
  ([]
    (problem2 4000000)) 
  ([max]
  (reduce
    +
    (filter even? (take-while #(< % max) (lazy-fib 1 2))))))

(defn problem3
  "What is the largest prime factor of the number 600851475143"
  ([]
    (problem3 600851475143))
  ([x]
    (gpf x)))

(defn problem4
  "Find the largest palindrome made from the product of two 3-digit numbers."
  ([]
  (problem4 3))
  ([dig]
  (reduce max (filter palindrome? (products  dig)))))
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

(defn problem5
  "What is the smallest positive number that is evenly divisible by all of 
   the numbers from 1 to 20?"
  ([]
    (problem5 20))
  ([max]
    (smalest-even-divisible max)))

(defn problem6
  "Find the difference between the sum of the squares of the first one hundred natural numbers and the
square of the sum."
  ([]
    (problem6 100))
  ([x]
    (let [max (+ 1 x)
          nums (range 1 max)]
      (- (square-sum nums) (sum-squares nums)))))

(defn problem7
  "What is the 10001st prime number?"
  ([]
    (problem7 10001))
  ([n]
    (let [n-1 (- n 1)]
      (first (drop n-1 (primes))))))

(defn problem8
  "Find the greatest product of five consecutive digits in the 1000-digit number."
  ([]
    (problem8 "731671765313306249192251196744265747423553491949349698352031277450632623957831801698480186947885184385861560789112949495459501737958331952853208805511125406987471585238630507156932909632952274430435576689664895044524452316173185640309871112172238311362229893423380308135336276614282806444486645238749303589072962904915604407723907138105158593079608667017242712188399879790879227492190169972088809377665727333001053367881220235421809751254540594752243525849077116705560136048395864467063244157221553975369781797784617406495514929086256932197846862248283972241375657056057490261407972968652414535100474821663704844031998900088952434506585412275886668811642717147992444292823086346567481391912316282458617866458359124566529476545682848912883142607690042"))
  ([s]
    (reduce max (map prod-chars (partition 5 1 s)))))


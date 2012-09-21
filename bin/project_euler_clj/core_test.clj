(ns project-euler-clj.core-test
  (:use clojure.test
        project-euler-clj.core))

(deftest test-problem1
  (testing "Answer is 233168"
    (is (= 233168 (problem1)))))

(deftest test-problem2
  (testing "Answer is 4613732"
    (is (= 4613732 (problem2)))))

(deftest test-problem3
  (testing "Answer is 6857"
    (is (= 6857 (problem3)))))

(deftest test-problem4
  (testing "Answer is 906609"
    (is (= 906609 (problem4)))))

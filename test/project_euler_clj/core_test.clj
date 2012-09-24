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

(deftest test-problem5
  (testing "Answer is 232792560"
    (is (= 232792560 (problem5)))))

(deftest test-problem6
  (testing "Answer is 25164150"
    (is (= 25164150 (problem6)))))

(deftest test-problem7
  (testing "Answer is 104743"
    (is (= 104743 (problem7)))))

(deftest test-problem8
  (testing "Answer is 40824"
    (is (= 40824 (problem8)))))


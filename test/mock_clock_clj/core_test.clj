(ns mock-clock-clj.core-test
  (:require
    [clojure.test :refer [deftest is testing]]
    [mock-clock-clj.core :refer
     [clock advance-by-days advance-by-hours advance-by-minutes advance-by-seconds advance-by-millis clock-reset]]
    [tick.core :as tick]))

(deftest clock-is-advanced-by-days
  (testing "advances clock by given number of days"
    (let [now (tick/instant "2020-01-01T00:00:00Z")
          current-clock (clock now)]
      (is (= (clock (tick/instant "2020-01-02T00:00:00Z"))
             (advance-by-days current-clock 1)))
      (is (= (clock (tick/instant "2020-01-03T00:00:00Z"))
             (advance-by-days current-clock 1))))))

(deftest clock-is-advanced-by-hours
  (testing "advances clock by given number of hours"
    (let [now (tick/instant "2020-01-01T00:00:00Z")
          current-clock (clock now)]
      (is (= (clock (tick/instant "2020-01-01T01:00:00Z"))
             (advance-by-hours current-clock 1)))
      (is (= (clock (tick/instant "2020-01-01T02:00:00Z"))
             (advance-by-hours current-clock 1))))))

(deftest clock-is-advanced-by-minutes
  (testing "advances clock by given number of minutes"
    (let [now (tick/instant "2020-01-01T00:00:00Z")
          current-clock (clock now)]
      (is (= (clock (tick/instant "2020-01-01T00:01:00Z"))
             (advance-by-minutes current-clock 1)))
      (is (= (clock (tick/instant "2020-01-01T00:02:00Z"))
             (advance-by-minutes current-clock 1))))))

(deftest clock-is-advanced-by-seconds
  (testing "advances clock by given number of seconds"
    (let [now (tick/instant "2020-01-01T00:00:00Z")
          current-clock (clock now)]
      (is (= (clock (tick/instant "2020-01-01T00:00:01Z"))
             (advance-by-seconds current-clock 1)))
      (is (= (clock (tick/instant "2020-01-01T00:00:02Z"))
             (advance-by-seconds current-clock 1))))))

(deftest clock-is-advanced-by-millis
  (testing "advances clock by given number of millis"
    (let [now (tick/instant "2020-01-01T00:00:00Z")
          current-clock (clock now)]
      (is (= (clock (tick/instant "2020-01-01T00:00:00.001Z"))
             (advance-by-millis current-clock 1)))
      (is (= (clock (tick/instant "2020-01-01T00:00:00.002Z"))
             (advance-by-millis current-clock 1))))))

(deftest clock-is-reset
  (testing "advances clock by given number of hours"
    (let [now (tick/instant "2020-01-01T00:00:00Z")
          current-clock (clock now)]
      (is (= (clock (tick/instant "2020-01-01T01:00:00Z"))
             (advance-by-hours current-clock 1)))

      (clock-reset current-clock now)

      (is (= (clock now)
             current-clock)))))

(ns mock-clock-clj.core
  (:require
    [tick.core :as tick])
  (:import
    (com.statemachinesystems.mockclock
      MockClock)
    (java.time
      Instant
      ZoneId)))

(def ^ZoneId utc-zone (ZoneId/of "UTC"))

(defn clock
  [date-time]
  (MockClock/at ^Instant (tick/instant date-time) utc-zone))

(defn advance-by-days
  [clock minutes]
  (.advanceByDays clock minutes))

(defn advance-by-hours
  [clock minutes]
  (.advanceByHours clock minutes))

(defn advance-by-minutes
  [clock minutes]
  (.advanceByMinutes clock minutes))

(defn advance-by-seconds
  [clock seconds]
  (.advanceBySeconds clock seconds))

(defn advance-by-millis
  [clock millis]
  (.advanceByMillis clock millis))

(defn clock-reset
  [clock date-time]
  (.set clock (tick/instant date-time)))

(defn with-clock-reset
  [system-atom date-time]
  (fn [f]
    #_:clj-kondo/ignore
    (do
      (clock-reset (:clock @system-atom) date-time)
      (f))))

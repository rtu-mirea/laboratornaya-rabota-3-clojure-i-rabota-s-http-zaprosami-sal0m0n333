(ns metrics-server.api.hardware
  (:require [metrics-server.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn get-metrics-with-http-info
  "Get hardware metrics"
  []
  (call-api "/hardware" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn get-metrics
  "Get hardware metrics"
  []
  (:data (get-metrics-with-http-info)))
; задание 1.1
(defn task_11 [metrics]
  (filter (fn [a] (> (get a :cpuTemp) 2)) metrics))
; задание 1.2
(defn task_12 [metrics]
  (/ (reduce + (map (fn [a] (get a :cpuTemp)) metrics)) (count metrics))
  )
; задание 1.3
(defn task_13 [metrics]
  (/ (reduce + (map (fn [a] (get a :cpuLoad)) metrics)) (count metrics))
  )

(defn -main [& args]
  (println (task_11 (get-metrics)))
  (println (task_12 (get-metrics)))
  (println (task_13 (get-metrics)))
  )

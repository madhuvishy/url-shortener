(ns url-shortener.core
  (:require [ring.adapter.jetty :refer :all]
            [url-shortener.server :as server]))

(defn -main [port]
  (let [port (Integer. port)]
    (run-jetty server/app {:port port :join? false})))

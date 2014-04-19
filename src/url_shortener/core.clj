(ns url-shortener.core
  (:require [ring.adapter.jetty :refer :all]
            [url-shortener.server :as server]))

(defn -main
  [& args]
  (run-jetty #'server/app {:port 8000}))

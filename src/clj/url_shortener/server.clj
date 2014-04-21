(ns url-shortener.server
  (:require [compojure.core :refer [defroutes GET PUT]]
            [compojure.route :as route]
            [ring.middleware.edn :refer [wrap-edn-params]]
            [ring.util.response :refer  [file-response]]))

(defn generate-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/edn"}
   :body (pr-str data)})

(defn index  []
  (file-response "public/html/dev.html"  {:root "resources"})
  #_(file-response "public/html/index.html"  {:root "resources"}))

(defroutes handler
  (GET "/"  [] (index))
  (route/files "/"  {:root "resources/public"}))

(def app
  (-> handler
      wrap-edn-params))


(ns url-shortener.server
  (:require [compojure.core :refer :all]
            [ring.middleware.edn :refer :all]))

(defn generate-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/edn"}
   :body (pr-str data)})

(defroutes handler
  (GET "/"  [] "<h1>Hello World</h1>") 
  (GET "/hello" [] (generate-response {:hello :cleveland}))
  (PUT "/" [name] (generate-response {:hello name})))

(def app
  (-> handler
      wrap-edn-params))


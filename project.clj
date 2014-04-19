(defproject url-shortener "0.0.1"
    :description "URL Shortener in Clojure"
    :dependencies  [[org.clojure/clojure "1.5.1"]
                    [ring "1.0.2"]
                    [compojure "1.0.1"]
                    [fogus/ring-edn "0.2.0"]]
    :main url-shortener.core)

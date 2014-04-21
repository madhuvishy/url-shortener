(defproject url-shortener "0.0.1"
    :description "URL Shortener in Clojure"
    :dependencies  [[org.clojure/clojure "1.5.1"]
                    [ring "1.0.2"]
                    [compojure "1.0.1"]
                    [fogus/ring-edn "0.2.0"]
                    [org.clojure/clojurescript "0.0-2173"]
                    [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                    [om "0.5.3"]
                    [com.cemerick/piggieback "0.1.3"] ]
    :source-paths ["src/clj"]
    :uberjar-name "url-shortener-standalone.jar"
    :plugins  [[lein-cljsbuild "1.0.2"]]
    :min-lein-version "2.0.0"
    :cljsbuild {
      :builds [{:id "dev"
                :source-paths ["src/cljs"]
                :compiler {
                  :output-to "resources/public/js/url_shortener_dev.js"
                  :output-dir "resources/public/js/out"
                  :optimizations :none
                  :source-map true}}
               {:id "release"
                :source-paths ["src/cljs"]
                :compiler {
                  :output-to "resources/public/js/url_shortener_release.js"
                  :optimizations :advanced
                  :pretty-print false
                  :preamble ["react/react.min.js"]
                  :externs ["react/externs/react.js"]}}]}

    :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
    :main url-shortener.core)

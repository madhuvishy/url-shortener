(ns url-shortener.core 
  (:require-macros  [cljs.core.async.macros :refer  [go]])
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs.core.async :refer  [put! chan <!]]
            [goog.Uri :as uri])
  (:import [goog Uri]))

(enable-console-print!)

;;Defining app state
(def app-state (atom {:url "http://google.com" }))

(defn url-shortener-view
  [app owner]
  (reify
    om/IRender
    (render [_]
      (dom/div nil (:url app)))))  

(om/root url-shortener-view app-state
         {:target (. js/document (getElementById "app"))})

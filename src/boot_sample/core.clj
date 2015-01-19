(ns boot-sample.core
  (:require [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [ring.middleware.json :refer [wrap-json-params]]
            [compojure.core :refer [defroutes ANY GET]]
            [liberator.core :refer [defresource resource]]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn index-handler [req]
  "Hello Boot sample (or maybe Lein still)")

(defresource booters
  :available-media-types       ["application/json"]
  :allowed-methods             [:get]
  :handle-ok                   (fn [ctx] [{:id "Pod1"} {:id "Pod 2"}]))

(defroutes app-routes
  (ANY "/" [] index-handler)
  (ANY "/booters" [] booters))


(def app (-> app-routes
             wrap-keyword-params
             wrap-json-params
             wrap-params))

(defn -main []
  (jetty/run-jetty app {:port 3360}))

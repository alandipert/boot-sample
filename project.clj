(defproject boot-sample "0.1.0"
  :description "Boot sample application"
  :url "https://github.com/rundis/boot-sample"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.1"]
                 [liberator "0.12.2"]
                 [ring/ring-jetty-adapter "1.3.1"]
                 [ring/ring-json "0.3.1"]
                 [bouncer "0.3.1"]
                 [io.aviso/pretty "0.1.14"]]
  :ring {:handler boot-sample.core/app
         :port 3360}
  :profiles {:dev {:plugins [[lein-ring "0.8.13"]]
                   :test-paths ^:replace []}
             :test {:dependencies [[midje "1.6.3"]]
                    :plugins [[lein-midje "3.1.3"]]
                    :test-paths ["test"]
                    :resource-paths ["test/resources"]}})

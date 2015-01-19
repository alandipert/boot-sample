(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.1"]
                 [liberator "0.12.2"]
                 [ring/ring-jetty-adapter "1.3.1"]
                 [ring/ring-json "0.3.1"]
                 [bouncer "0.3.1"]
                 [io.aviso/pretty "0.1.14"]])

(task-options!
 pom {:project 'boot-sample
      :version "0.1.0"}
 aot {:namespace '#{boot-sample.core}}
 jar {:main 'boot_sample.core
      :manifest {"Description" "Sample boot app"
                 "Url" "https://github.com/rundis/boot-sample"}})


(deftask build
  "Build uberjar"
  []
  (comp (aot) (pom) (uber) (jar)))

(defproject pact-lein-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    ; [jansi-clj "0.1.0"]
  ]
  :main ^:skip-aot pact-lein-test.core
  :target-path "target/%s"
  :profiles {
    :uberjar {:aot :all}
    :pact {
            :plugins [[au.com.dius/pact-jvm-provider-lein_2.11 "3.2.11" :exclusions [commons-logging]]]
            :dependencies [[ch.qos.logback/logback-core "1.1.3"]
                           [ch.qos.logback/logback-classic "1.1.3"]
                           [org.apache.httpcomponents/httpclient "4.4.1"]
                          ;  [jansi-clj "0.1.0"]
                           ]
    }
  }

  :pact {
      :service-providers {
          ; You can define as many as you need, but each must have a unique name
          :provider1 {
              ; All the provider properties are optional, and have sensible defaults (shown below)
              :protocol "http"
              :host "localhost"
              :port 5050
              :path "/"

              :has-pact-with {
                  ; Again, you can define as many consumers for each provider as you need, but each must have a unique name
                  :consumer1 {
                    ; pact file can be either a path or an URL
                    :pact-file "file:test/sample-pact.json"
                  }
              }
          }
      }
  }
)

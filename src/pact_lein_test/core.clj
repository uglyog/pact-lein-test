(ns pact-lein-test.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (. System getProperty "java.library.path")))

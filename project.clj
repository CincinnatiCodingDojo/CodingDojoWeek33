(defproject dojo.week33 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot dojo.week32
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[midje "1.6.3"]]
                   :repl-options {:init (require '[midje.repl :refer [autotest]])}}})

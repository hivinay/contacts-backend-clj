(defproject contacts-backend-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "GPL v3"
            :url "http://www.gnu.org/licenses/gpl-3.0.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-json "0.3.1"]
                 [compojure "1.4.0"]
                 [http-kit "2.1.19"]
                 [org.clojure/java.jdbc "0.3.7"]
                 [postgresql "9.3-1102.jdbc41"]
                 [heroku-database-url-to-jdbc "0.2.2"]]
  :min-lein-version "2.0.0"
  :main ^:skip-aot contacts-backend-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

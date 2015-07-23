(ns contacts-backend-clj.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [contacts-backend-clj.db :as db]
            [contacts-backend-clj.access :refer [access-headers]]))

(defroutes contacts-app
  (GET "/contacts" []
       {:status 200
        :body (db/get-items)})
  (POST "/contacts" request
        (db/add-item (:body request))))

(defn handler
  []
  (-> contacts-app
      access-headers
      wrap-json-response
      (wrap-json-body {:keywords? true})))

(defn -main
  []
  (do (db/create-table)
      (println "Running...")
      (run-server (handler) {:port (read-string (System/getenv "PORT"))})))

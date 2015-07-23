(ns contacts-backend-clj.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [contacts-backend-clj.db :as db]
            [ring.middleware.cors :refer [wrap-cors]]))

(defroutes contacts-app
  (GET "/contacts" []
       (->> (db/get-items)
            (assoc {:status 200} :body)))
  (POST "/contacts" request
        (-> request
            :body
            db/add-item)))

(defn handler
  []
  (wrap-cors (wrap-json-response (wrap-json-body contacts-app {:keywords? true}))
             :access-control-allow-methods [:get :post]))

(defn -main
  []
  (do (db/create-table)
      (println "Running...")
      (run-server (handler) {:port (read-string (System/getenv "PORT"))})))

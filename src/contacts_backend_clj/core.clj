(ns contacts-backend-clj.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [contacts-backend-clj.db :as db]))

(defroutes contacts-app
  (GET "/contacts" []
       (->> (db/get-items)
            (assoc {:status 200} :body)))
  (POST "/contacts" request
        (-> request
            :body
            db/add-item)))

(defn -main
  []
  (do (println "Running...")
      (run-server (wrap-json-response (wrap-json-body contacts-app {:keywords? true}))
                  {:port (read-string (System/getenv "PORT"))})))

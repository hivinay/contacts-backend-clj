(ns contacts-backend-clj.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]
            [ring.middleware.json :refer [wrap-json-body]]
            [contacts-backend-clj.db :as db]))

(defn contact->string
  [contact]
  (str "Name: " (:name contact) ", "
       "Email: " (:email contact) "\n"))

(defroutes contacts-app
  (GET "/notes" []
       (->> (db/get-items)
            (map contact->string)
            (assoc {:status 200} :body)))
  (POST "/notes" request
        (-> request
            :body
            db/add-item)
        "Success"))

(defn -main
  []
  (do (println "Running...")
      (run-server (wrap-json-body contacts-app {:keywords? true})
                  {:port (read-string (System/getenv "PORT"))})))

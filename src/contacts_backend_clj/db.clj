(ns contacts-backend-clj.db
  (:require [clojure.java.jdbc :as jdbc]
            [heroku-database-url-to-jdbc.core :as h]))

(def postgres-db (h/jdbc-connection-string (System/getenv "DATABASE_URL")))

(defn create-table
  []
  (jdbc/db-do-commands postgres-db
   "CREATE TABLE IF NOT EXISTS contacts (
name text,
email text,
created timestamp DEFAULT CURRENT_TIMESTAMP);"))

(defn add-item
  [item]
  (jdbc/insert! postgres-db :contacts
              {:name (:name item)
               :email (:email item)}))

(defn get-items
  []
  (jdbc/query postgres-db [(str "SELECT * FROM contacts")]))

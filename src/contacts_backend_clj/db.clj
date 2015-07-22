(ns contacts-backend-clj.db
  (:require [clojure.java.jdbc :as db]
            [heroku-database-url-to-jdbc.core :as h]))

(def postgres-db (h/jdbc-connection-string (System/getenv "DATABASE_URL")))

(def db-table
  (keyword (System/getenv "DB_TABLE")))

(defn add-item
  [item]
  (db/insert! postgres-db db-table
              {:name (:name item)
               :email (:email item)}))

(defn get-items
  []
  (db/query postgres-db [(str "SELECT * FROM " (System/getenv "DB_TABLE"))]))

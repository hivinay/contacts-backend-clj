(ns contacts-backend-clj.db
  (:require [clojure.java.jdbc :as db]))

(def postgres-db {:subprotocol "postgresql"
                  :subname (str "//" (System/getenv "DB_HOST") ":5432/" (System/getenv "DB_NAME"))
                  :user (System/getenv "DB_USER")})

(def db-name
  (keyword (System/getenv "DB_TABLE")))

(defn add-random-items
  []
  (db/insert! postgres-db db-name
              {:name "Name1" :email "Email1"}
              {:name "Name2" :email "Email2"}))

(defn add-item
  [item]
  (db/insert! postgres-db db-name
              {:name (:name item)
               :email (:email item)}))

(defn get-items
  []
  (db/query postgres-db [(str "SELECT * FROM " (System/getenv "DB_TABLE"))]))

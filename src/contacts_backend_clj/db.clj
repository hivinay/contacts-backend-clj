(ns contacts-backend-clj.db
  (:require [clojure.java.jdbc :as db]))

(def postgres-db {:subprotocol "postgresql"
                  :subname "//localhost:5432/test"
                  :user "vinay"})

(defn add-random-items
  []
  (db/insert! postgres-db :contacts
              {:name "Name1" :email "Email1"}
              {:name "Name2" :email "Email2"}))

(defn add-item
  [item]
  (db/insert! postgres-db :contacts
              {:name (:name item)
               :email (:email item)}))

(defn get-items
  []
  (db/query postgres-db ["SELECT * FROM contacts"]))

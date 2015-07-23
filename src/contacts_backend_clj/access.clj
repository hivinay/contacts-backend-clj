(ns contacts-backend-clj.access)

(def headers
  { "Access-Control-Allow-Origin" "*"
    "Access-Control-Allow-Headers" "Content-Type"
    "Access-Control-Allow-Methods" "GET,POST,OPTIONS" })

(defn access-headers
  "Allow requests from all origins"
  [handler]
  (fn [request]
    (let [response (handler request)]
      (update-in response [:headers]
                 merge headers))))

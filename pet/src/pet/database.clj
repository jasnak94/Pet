(ns pet.database
   (:require [clojure.java.jdbc :as sql])
  )

(def connection 
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost/petprotectors"
   :user "root"
   :password ""})

(defn brKorisnika []
   (into [] (sql/query connection ["SELECT count(*) as ukupno FROM novikorisnik"]))
)
(defn brNestanka []
   (into [] (sql/query connection ["SELECT count(*) as ukupno FROM prijavanestanka"]))
)
(defn brPronalaska []
   (into [] (sql/query connection ["SELECT count(*) as ukupno FROM prijavapronalaska"]))
)
(defn brNasilja []
   (into [] (sql/query connection ["SELECT count(*) as ukupno FROM prijavanasilja"]))
)
(defn vrstaZivotinje []
  (into [] (sql/query connection ["SELECT * FROM vrstazivotinje"]))
  )
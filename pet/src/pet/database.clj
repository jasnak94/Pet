(ns pet.database
   (:require [clojure.java.jdbc :as sql])
  )

(def connection 
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//localhost/petprotectors"
   :user "root"
   :password ""})

(defn brNestanka []
   (into [] (sql/query connection ["SELECT count(*) as ukupno FROM prijavanestanka"]))
)

(defn brPronalaska []
   (into [] (sql/query connection ["SELECT count(*) as ukupno FROM prijavapronalaska"]))
)

(defn vrstaZivotinje []
  (into [] (sql/query connection ["SELECT * FROM vrstazivotinje"]))
)

(defn rase []
  (into [] (sql/query connection ["SELECT * FROM rasa"]))
)

(defn dodajNestanak [mestonestanka]
     (sql/insert! connection :prijavanestanka [:ulicaGrad :datumPrijave :zivotinjaid] 
                  [mestonestanka (java.time.LocalDateTime/now) 
                  (first (vals (get (into [] (sql/query connection ["SELECT * FROM zivotinja ORDER BY id DESC LIMIT 1"])) 0)))
                    ]
      )
)

(defn dodajZivotinju [vrsta rasa pol bdlaka vdlaka brcip sterilisana pobelezja]
  (sql/insert! connection :zivotinja [:ime :pol :bojaDlake :vrstaDlake :brojCipa :sterilisana :posebnaObelezja :IDRase] 
               [vrsta pol bdlaka vdlaka brcip sterilisana pobelezja rasa])
)
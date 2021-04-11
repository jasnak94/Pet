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
                  (first (vals (get (into [] (sql/query connection ["SELECT id FROM zivotinja ORDER BY id DESC LIMIT 1"])) 0)))
                    ]
      )
)

(defn dodajZivotinju [vrsta rasa ime pol bdlaka vdlaka brcip sterilisana pobelezja slika status]
  (sql/insert! connection :zivotinja [:ime :pol :bojaDlake :vrstaDlake :brojCipa :sterilisana :posebnaObelezja :slika :IDRase :status] 
               [ime pol bdlaka vdlaka brcip sterilisana pobelezja slika rasa status])
)

(defn vratioglase []
  (into [] (sql/query connection ["SELECT z.ime as ime, z.status as status,z.pol as pol,z.bojaDlake as bdlake, 
z.vrstaDlake as vdlake, z.sterilisana as ster, z.posebnaObelezja as pobelezja, z.brojcipa as brcipa, z.slika as slika , r.rasa as rasa,
p.ulicaGrad as mesto, p.datumPrijave as datum 
from zivotinja z join rasa r on z.IDRase=r.id join prijavanestanka p on z.id=p.zivotinjaid"]))
  )
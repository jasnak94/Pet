(ns pet.core
  (:use [hiccup.element :only (link-to)])
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]
            [compojure.core :refer [defroutes ANY]]
            [compojure.route :as route]
            [ring.util.response :as ring]
            [compojure.core :refer [defroutes GET POST]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [pet.sections :as s]
            [pet.template :as t]
            [pet.database :as db]
            [clojure.java.io :as io]
            [clojure.contrib [duck-streams :as ds]]
            [ring.middleware [multipart-params :as mp]]
            )
  )

 (defn pocetna []
  (t/view (s/pocetna))
)
 
(defn pregledOglasa [id]
  (t/view (s/pregled id))
  )

(defn oglasi []
  (t/view (s/portfolio))
  )

(defn prijavaNestanka []
  (t/view (s/nestanak))
  )

(defn izmenaNestanka [id]
  (t/view (s/nestanak))
  )

(defn upload-file [file naziv]
 (if-not (= file nil)
   (do (ds/copy (file :tempfile) (ds/file-str naziv) )
     (io/copy (io/file naziv) (io/file (str "resources/public/img/zivotinje/" naziv)) )
     (io/delete-file naziv)
   ))
 )

 (defn dodajNestanak [vrsta rasa ime pol bdlaka vdlaka brcip sterilisana mestonestanka  kontakt sifra pobelezja imgLink]
   (def naziv (str (str pol (str ime vrsta)) ".jpg"))
   (upload-file imgLink naziv)
  (db/dodajZivotinju vrsta rasa ime pol bdlaka vdlaka brcip sterilisana pobelezja naziv "NESTALA")
  (db/dodajNestanak mestonestanka kontakt sifra)
   (ring/redirect "/oglasi")
  )
 
 (defn obisiNestanak [id zid]
  (db/obrisiNestanak id zid)
   (ring/redirect "/oglasi")
  )
 
(defroutes routes
 (GET "/" [] (pocetna))
 (GET "/oglasi" [] (oglasi))
 (GET "/prijavan" [] (prijavaNestanka))
 (mp/wrap-multipart-params
 (POST "/add" 
       [vrsta rasa ime pol bdlaka vdlaka brcip sterilisana mestonestanka kontakt sifra pobelezja file] 
       (dodajNestanak vrsta rasa ime pol bdlaka vdlaka brcip sterilisana mestonestanka kontakt sifra pobelezja file))
 )
 (POST "/pregled" [idnestanka] (pregledOglasa idnestanka))
 (GET "/izmena/:id" [id] (izmenaNestanka id))
 (POST "/izmena" [idnestanka] (izmenaNestanka idnestanka))
 (POST "/delete" [id zid] (obisiNestanak id zid))
 (route/resources "/"))

(def foo
  (wrap-defaults routes api-defaults))


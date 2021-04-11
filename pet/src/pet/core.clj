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
            [pet.database :as db]
            [clojure.java.io :as io]
            [clojure.contrib [duck-streams :as ds]]
            [ring.middleware [multipart-params :as mp]]
            )
  )

 (defn index []
  (h/html5
    [:head
     [:title "PetPROTECTORS"]
     (include-css "/css/style.css" "/css/RegCss.css" "/css/bootstrap.min.css"
                  "/css/font-awesome.min.css" "/css/animate.min.css" "/css/jquery-ui.min.css"
                  "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css")
     ]
    [:body {:class "homepage"}
      [:header {:id "header"}
    [:div {:class "container"}

      [:div {:id "logo" :class "pull-left"}
        [:a {:href "#hero"}]
        [:h3 [:a {:href  "#hero"}"PetProtectors"]]
        ]

      [:nav {:id "nav-menu-container"}
        [:ul {:class "nav-menu"}
          [:li {:class ""}[:a {:href "#hero"} "Početna strana"]]
           [:li [:a {:href "#about"} "O portalu"]]
           [:li [:a {:href "#services"} "Usluge"]]
           [:li [:a {:href "#portfolio"} "Oglasi"]]
        ]
      ]
    ]
  ]
   (s/hero)
    [:main {:id "main"}
    (s/about)
    (s/facts)
    (s/services)
    (s/portfolio)
    (s/nestanak)
    ]
    
    [:footer {:id "footer"}
    [:div {:class "footer-top"}
      [:div {:class "container"}

      ]
    ]

    [:div {:class "container"}
      [:div {:class "copyright"}
        "&copy; Copyright " [:strong "petPROTECTORS"]".Sva prava zadržana"
      ]
      
    ]
  ]
   ])
  )

(defn upload-file [file naziv]
 (if-not (= file nil)
   (do (ds/copy (file :tempfile) (ds/file-str naziv) )
     (io/copy (io/file naziv) (io/file (str "resources/public/img/zivotinje/" naziv)) )
     (io/delete-file naziv)
   ))
 )

 (defn dodajNestanak [vrsta rasa ime pol bdlaka vdlaka brcip sterilisana mestonestanka pobelezja imgLink]
   (def naziv (str (str pol (str ime vrsta)) ".jpg"))
   (upload-file imgLink naziv)
  (db/dodajZivotinju vrsta rasa ime pol bdlaka vdlaka brcip sterilisana pobelezja naziv "NESTALA")
  (db/dodajNestanak mestonestanka)
   (ring/redirect "/")
  )
 
(defroutes routes
 (GET "/" [] (index))
 (mp/wrap-multipart-params
 (POST "/add" [vrsta rasa ime pol bdlaka vdlaka brcip sterilisana mestonestanka pobelezja file] (dodajNestanak vrsta rasa ime pol bdlaka vdlaka brcip sterilisana mestonestanka pobelezja file))
 )
 (route/resources "/"))

(def foo
  (wrap-defaults routes api-defaults))


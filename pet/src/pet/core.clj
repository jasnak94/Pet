(ns pet.core
  (:use [hiccup.element :only (link-to)])
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]
            [compojure.core :refer [defroutes ANY]]
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [pet.sections :as s])
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
        ]
      ]
    ]
  ]
   (s/hero)
    
    [:main {:id "main"}
    (s/about)
    (s/services)
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

(defroutes routes
 (GET "/" [] (index))
 (route/resources "/"))

(def foo
  (wrap-defaults routes site-defaults))


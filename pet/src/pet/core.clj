(ns pet.core
  (:use [hiccup.element :only (link-to)])
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]
            [compojure.core :refer [defroutes ANY]]
            [compojure.route :as route]
            [compojure.core :refer [defroutes GET POST]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  )

 (defn index []
  (h/html5
    [:head
     [:title "PetProtectors"]
     (include-css "/css/style.css" "/css/RegCss.css" "/css/bootstrap.min.css"
                  "css/font-awesome.min.css" "/css/animate.min.css"
                  "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css")
     ]
    [:body {:class "homepage"}
      [:header {:id "header"}
    [:div {:class "container"}

      [:div {:id "logo" :class "pull-left"}
        [:a {:href "#hero"} [:img {:src "" :alt "" :title "" }]]
       
        [:h3 [:a {:href  "#hero"}"PetProtectors"]]
        ]

      [:nav {:id "nav-menu-container"}
        [:ul {:class "nav-menu"}
          [:li {:class ""}[:a {:href "#hero"} "Početna strana"]]
          
        ]
      ]
    ]
  ]
   [:section {:id "hero"}
     [:div {:class "hero-container"}
       [:h3 "Dobrodošli na portal pomoći vašim izgubljenim ljubimcima"]
       [:h4 "Tu smo da povratimo vaše voljene drugare"]
       [:a {:href "#about" :class "btn-get-started"} "Upoznajte se sa nama"]
     ]
   ]]
   )
  )

(defroutes routes
 (GET "/" [] (index))
 (route/resources "/"))

(def foo
  (wrap-defaults routes site-defaults))


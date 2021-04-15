(ns pet.template
  (:require [hiccup.page :as h]
            [hiccup.page :refer [html5 include-css]]
            [pet.sections :as s])
  )

(defn view [section]
  (h/html5
    [:head
     [:title "PetPROTECTORS"]
     (include-css "/css/style.css" "/css/RegCss.css" "/css/bootstrap.min.css" "/css/bootstrap-responsive.min.css"
                  "/css/font-awesome.min.css" "/css/animate.min.css" "/css/jquery-ui.min.css"
                  "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css")
     ]
    [:body {:class "homepage"}
      [:header {:id "header"}
    [:div {:class "container"}

      [:div {:id "logo" :class "pull-left"}
        [:a {:href "#hero"}]
        [:h3 [:a {:href  "#hero"  :style "text-decoration: none"}"PetProtectors"]]
        ]

      [:nav {:id "nav-menu-container"}
        [:ul {:class "nav-menu"}
          [:li {:class ""}[:a {:href "/" :style "color: #fff;text-decoration: none"} "Početna strana"]]
           [:li [:a {:href "/#about" :style "color: #fff;text-decoration: none"} "O portalu"]]
           [:li [:a {:href "/#services" :style "color: #fff;text-decoration: none"} "Usluge"]]
           [:li [:a {:href "/oglasi" :style "color: #fff;text-decoration: none"} "Oglasi"]]
           [:li [:a {:href "/prijavan" :style "color: #fff;text-decoration: none"} "Prijavi nestanak"]]
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
   ]
    [:main {:id "main"}
     section
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
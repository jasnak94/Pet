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
     [:title "PetPROTECTORS"]
     (include-css "/css/style.css" "/css/RegCss.css" "/css/bootstrap.min.css"
                  "/css/font-awesome.min.css" "/css/animate.min.css"
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
           [:li [:a {:href "#about"} "O portalu"]]
           [:li [:a {:href "#services"} "Usluge"]]
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
    [:section {:id "about"}
      [:div {:class "container"}
        [:div {:class "row about-container"}

          [:div {:class "col-lg-6 content order-lg-1 order-2"}
            [:h2 {:class "title"}"Ukratko o nama"]
            [:p
             "PetPROTECTORS je prvi srpski portal gde vlasnici kućnih ljubimaca mogu da očekuju podršku u pronalasku izgubljenih ljubimaca.
             Vlasnici u svakom trenutku imaju mogućnost:"
            ]

            [:div {:class "icon-box wow fadeInUp"}
              [:div {:class "icon"} [:i {:class "fa fa-shopping-bag"}]]
              [:h4 {:class "title"}[:a {:href ""} "Kontaktiranja pronalazača"]]
              [:p {:class "description"} "Pronalazač veoma lako može da se poveže sa vlasnikom ljubimca, preko portala"]
            ]

            [:div {:class "icon-box wow fadeInUp" :data-wow-delay "0.2s"}
               [:div {:class "icon"} [:i {:class "fa fa-photo"}]]
              [:h4 {:class "title"}[:a {:href ""} "Postavljanje oglasa"]]
              [:p {:class "description"} "Registrovan korisnik može da postavi oglas sa prepoznatljivom slikom svog ljubimca, kojeg će ostali korisnici biti u prilici da pregledaju"]
            ]

            [:div {:class "icon-box wow fadeInUp" :data-wow-delay "0.4s"}
              [:div {:class "icon"} [:i {:class "fa fa-bar-chart"}]]
              [:h4 {:class "title"}[:a {:href ""} "uvida u Statistiku prijava nestanka i nasilja nad životinjama"]]
              [:p {:class "description"} "Registrovan korisnik može u svakom trenutku prijaviti nasilje nad životinjama"]
            ]
            ]
          [:div {:class "col-lg-6 background order-lg-2 order-1 wow fadeInRight"}]
        ]
      ]
    ]
    [:section {:id "services"}
     [:div {:class "container wow fadeIn"}
        [:div {:class "section-header"}
               [:h3 {:class "section-title"}"Usluge"]
               [:p {:class "section-description"} "Šta nudimo da bismo zaštitili one koje volimo?"]
            ]
             [:div {:class "row"}
               [:div {:class "col-lg-4 col-md-6 wow fadeInUp" :data-wow-delay "0.2s"}
                 [:div {:class "box"}
                   [:div {:class "icon"}[:a {:href ""}[:i {:class "fa fa-desktop"}]]]
                   [:h4 {:class "title"}[:a {:href ""}"Prijava nestanka"]]
                   [:p {:class "description"}"Poštovani vlasnici, u okviru ove sekcije omogućeno Vam je da prijavite nestanak svog ljubimca. Pre same prijave, potrebno je da otvorite svoj korisnički nalog. Od Vas očekujemo da u potpunosti unesete validne podatke o vašem ljubimcu, jer u suprotnom pronalazači neće biti u mogućnosti da identifikuju da li je u pitanju vaš ljubimac. Takođe, pruža Vam se mogućnost da ponudite nagradu pronalazaču. Želimo Vam puno sreće."]
                 ]
               ]
               [:div {:class "col-lg-4 col-md-6 wow fadeInUp" :data-wow-delay "0.4s"}
                 [:div {:class "box"}
                   [:div {:class "icon"}[:a {:href ""}[:i {:class "fa fa-bar-chart"}]]]
                   [:h4 {:class "title"}[:a {:href ""}"Prijava pronalaska"]]
                   [:p {:class "description"}"Sekcija prijave pronalaska služi da prijavite pronađenog ljubimca koji se ne nalazi u odeljku Oglasa korisnika.Prijavite pronalazak pre ostalih."]
                 ]
               ]
               [:div {:class "col-lg-4 col-md-6 wow fadeInUp" :data-wow-delay "0.6s"}
                 [:div {:class "box"}
                   [:div {:class "icon"}[:a {:href ""}[:i {:class "fa fa-paper-plane"}]]]
                   [:h4 {:class "title"}[:a {:href ""}"Prijava nasilja"]]
                   [:p {:class "description"}"Sekcija prijave nasilja nad životinjama"]
                 ]]
               ]
             ]
     ]
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

  [:a {:href "#" :class "back-to-top"} "Povratak na početak." [:i {:class "fa fa-chevron-up"}]]
   ])
  )

(defroutes routes
 (GET "/" [] (index))
 (route/resources "/"))

(def foo
  (wrap-defaults routes site-defaults))


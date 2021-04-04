(ns pet.sections
  (:require [pet.database :as db]
            [hiccup.form :as form]
            [ring.util.anti-forgery :as anti-forgery]
            )
  )

(defn hero []
  [:section {:id "hero"}
     [:div {:class "hero-container"}
       [:h3 "Dobrodošli na portal pomoći vašim izgubljenim ljubimcima"]
       [:h4 "Tu smo da povratimo vaše voljene drugare"]
       [:a {:href "#about" :class "btn-get-started"} "Upoznajte se sa nama"]
     ]
   ]
  )
(defn about []
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
  )

(defn services []
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
                   [:p {:class "description"}"Poštovani vlasnici, u okviru ove sekcije omogućeno Vam je da prijavite nestanak svog ljubimca. Od Vas očekujemo da u potpunosti unesete validne podatke o vašem ljubimcu, jer u suprotnom pronalazači neće biti u mogućnosti da identifikuju da li je u pitanju vaš ljubimac. Takođe, pruža Vam se mogućnost da ponudite nagradu pronalazaču. Želimo Vam puno sreće."]
                 ]
               ]
               [:div {:class "col-lg-4 col-md-6 wow fadeInUp" :data-wow-delay "0.4s"}
                 [:div {:class "box"}
                   [:div {:class "icon"}[:a {:href ""}[:i {:class "fa fa-bar-chart"}]]]
                   [:h4 {:class "title"}[:a {:href ""}"Prijava pronalaska"]]
                   [:p {:class "description"}"Sekcija prijave pronalaska služi da prijavite pronađenog ljubimca koji se ne nalazi u odeljku Oglasa korisnika. Prijavite pronalazak pre ostalih."]
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
  )

(defn facts []
      [:section {:id "facts"}
      [:div {:class "container wow fadeIn"}
        [:div {:class "section-header"}
          [:h3 {:class "section-title"} "Statistika prijava"]
          [:p {:class "section-description"}]
        ]
        [:div {:class "row counters"}

          [:div {:class "col-lg-4 col-6 text-center"}
           [:span {:data-toggle "counter-up"}
            (map 
          (fn [nesto]
            (:ukupno nesto)
            ) (db/brNestanka))
             ]
            [:p "Broj oglasa nestanka"]
  				]

          [:div {:class "col-lg-4 col-6 text-center"}
           [:span {:data-toggle "counter-up"} 
            (map 
          (fn [nesto]
            (:ukupno nesto)
            ) (db/brNasilja))
             ]
            [:p "Broj prijava nasilja nad životinjama"]
  				]
          [:div {:class "col-lg-4 col-6 text-center"}
           [:span {:data-toggle "counter-up"} 
            (map 
          (fn [nesto]
            (:ukupno nesto)
            ) (db/brPronalaska))
             ]
            [:p "Broj slučajeva vraćenih ljubimaca vlasnicima"]
  				]
          ]
        ]
      ]
  )

(defn formaNestanak [vrste]
  (form/form-to [:post "/add"]
    (anti-forgery/anti-forgery-field)
     [:div {:class "form-group"} 
      [:label {:for "vrsta"}[:span {:class "req"}]"Vrsta životinje:"]   
      [:select {:name "zivotinja_vrsta" :class "form-control"}
       (map (fn [vrsta]
                 [:option {:value (:id vrsta) } (:naziv vrsta)]) vrste)]
      ]
     [:div {:class "form-group"}
       [:label {:for "rasa"}[:span {:class "req"}]"Rasa:"] 
        [:input {:class "form-group" :type "text" :name "zivotinja_rasa" :placeholder "" :id "txt"
                       :size "32"}]
        [:p "Ukoliko Vam rasa nije poznata, unesite 'Nepoznata...'"]
     ]
     
     [:div {:class "form-group"}   
        [:label {:for "imeZivotinje"}[:span {:class "req"}]"Ime:"]
        [:input {:class "form-control" :type "text" :name "zivotinja_ime" :id "ime"}]
     ]
     [:div {:class "form-group"}
	     [:label {:for "pol"}[:span {:class "req"}] "Pol:"] [:br]
	     [:label {:for "radio-1"}"Muški"]
	     [:input {:type "radio"  :id "radio-1" :name "zivotinja_pol" :value "M"}]
	     [:label {:for "radio-2"}"Ženski"]
	     [:input {:type "radio" :id "radio-2" :name "zivotinja_pol" :value="Z"}]
	     [:input {:type "radio"  :id "radio-3" :style "display: none" :name"zivotinja_pol"}]
	
	     [:div {:class "status" :id "status"}]
     ]
     [:div {:class "form-group"}
       [:label {:for "bojaDlake"}[:span {:class "req"}] "Boja dlake:"]
       [:input {:class "form-control" :type "text" :name "zivotinja_bdlaka" :id "bdlaka" :placeholder "" :required "true"}]  
     ]
     [:div {:class "form-group"}
       [:label {:for "vrstaDlake"}[:span {:class "req"}] "Vrsta dlake:"] 
       [:input {:class "form-control" :type "text" :name "zivotinja_vdlaka" :id "vdlaka" :placeholder "" :required "true"}]  
     ]
     [:div {:class "form-group"}
       [:label {:for "brojCipa"}[:span {:class "req"}] "Broj cipa:"]
       [:input {:class "form-control" :type "text" :name "zivotinja_brcip" :id "brcip" :placeholder "" :required "true"}] 
     ]
    [:div {:class "form-group"}

    [:label {:for "sterilisana"}[:span {:class "req"}] "Sterilisana:"] [:br]
    [:label {:for "radio-11"}"Da"]
    [:input {:type "radio" :id "radio-11" :name "zivotinja_sterilisana" :value "Da"}]
    [:label {:for "radio-22"}"Ne"]
    [:input {:type "radio" :id "radio-22" :name "zivotinja_sterilisana" :value "Ne"}]
    [:input {:type "radio" :id "radio-33" :style "display: none" :name "zivotinja_sterilisana"}]

     [:div {:class "status" :id "status"}]
]
    [:div {:class "form-group"}
      [:label {:for "mestoNestanka"}[:span {:class "req"}] "Mesto nestanka:"]
      [:input {:class "form-control" :type "text" :name "mestoNestanka" :id "pobelezja"}] 
    ]
    [:div {:class "form-group"}
      [:label {:for "posebnaObelezja"}[:span {:class "req"}] "Posebna obeležja:"] 
      [:input {:class "form-control" :type "text" :name "zivotinja_pobelezja" :id "pobelezja" :placeholder "Navesti ukratko"}]  
    ]
    [:div {:class "form-group"}
      [:input {:class "btn btn-success" :type "submit" :name "prijava_nestanak" :value "Prijavi nestanak"}]
    ]
  )
  )

(defn nestanak []
  [:section {:id "nestanak"}
      [:div {:class "container wow fadeIn"}
        [:div {:class "section-header"}
          [:h3 {:class "section-title"}"Prijava nestanka"]
          ]
        [:div {:class "container wow fadeInUp"}
[:div {:class "container"}
  [:div {:class "row"}
        [:div {:class "col-md-10"}

(formaNestanak (db/vrstaZivotinje))
      ]
   ]
  ]]]]
  )

(defn portfolio []
   [:section {:id "portfolio"}
     [:div {:class "container wow fadeIn"}
        [:div {:class "section-header"}
          [:h3  {:class "section-title"}"Oglasi korisnika"]
          [:p {:class "section-description"}"Skorašnji oglasi koji su korisnici postavljali"]
        ]
        [:div {:class "row"}
          [:div {:class "col-lg-12"}
            [:ul {:id "portfolio-flters"}
              [:li {:data-filter ".filter-app, .filter-card, .filter-logo, .filter-web" :class "filter-active"}"Svi oglasi"]
              [:li {:data-filter ".filter-app"}"Nestanak"]
              [:li {:data-filter ".filter-app"}"Nasilje"]
              ]
          ]
        ]
      ]
   ]
)
(ns pet.sections
  (:require [pet.database :as db]
            [hiccup.form :as form]
            [hiccup.element :refer (link-to image)]
            [ring.util.anti-forgery :as anti-forgery]
            )
  )

(defn pocetna []
  [:div 
   [:section {:id "hero"}
     [:div {:class "hero-container"}
       [:h3 "Dobrodošli na portal pomoći vašim izgubljenim ljubimcima"]
       [:h4 "Tu smo da povratimo vaše voljene drugare"]
       [:a {:href "#about" :class "btn-get-started"} "Upoznajte se sa nama"]
     ]
   ]
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
              [:p {:class "description"} "Korisnik može da postavi oglas svog ljubimca, kojeg će ostali korisnici biti u prilici da pregledaju. Korisnik takođe može u svakom trenutku obrisati ili izmeniti svoj oglas"]
            ]

            [:div {:class "icon-box wow fadeInUp" :data-wow-delay "0.4s"}
              [:div {:class "icon"} [:i {:class "fa fa-bar-chart"}]]
              [:h4 {:class "title"}[:a {:href ""} "uvida u Statistiku prijava nestanka životinja"]]
              [:p {:class "description"} "Korisnik može u svakom trenutku videti statistiku nestanka životinja"]
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
               [:div {:class " wow fadeInUp" :data-wow-delay "0.2s"}
                 [:div {:class "box"}
                   [:div {:class "icon"}[:a {:href ""}[:i {:class "fa fa-desktop"}]]]
                   [:h4 {:class "title"}[:a {:href ""}"Prijava nestanka"]]
                   [:p {:class "description"}"Poštovani vlasnici, omogućeno Vam je da prijavite nestanak svog ljubimca. Od Vas očekujemo da u potpunosti unesete validne podatke o vašem ljubimcu, jer u suprotnom pronalazači neće biti u mogućnosti da identifikuju da li je u pitanju vaš ljubimac. Takođe, pruža Vam se mogućnost da nakon što vas neko kontaktira, odnosno kada se potraga uspešno završi, Vi obrišete oglas. Ukoliko ste pogrešili pri unosu nekog od podataka, oglas možete u svakom trenutku izmeniti tako što odete u sekciju Oglasi i otvorite svoj. Pri izmeni i brisanju,  potrebno je da unesete svoju šifru koju ste uneli pri prvom unosu oglasa. Želimo Vam puno sreće!"]
                 ]
               ]
               ]
             ]
     ]
   
   [:section {:id "facts"}
      [:div {:class "container wow fadeIn"}
        [:div {:class "section-header"}
          [:h3 {:class "section-title"} "Statistika prijava"]
          [:p {:class "section-description"}]
        ]
        [:div {:class "row counters"}

          [:div {:class "col-lg-12 col-12 text-center"}
           [:span {:data-toggle "counter-up"}
            (map 
          (fn [nesto]
            (:ukupno nesto)
            ) (db/brNestanka))
             ]
            [:p "Broj oglasa nestanka"]
  				]
          ]
        ]
      ]
   ]
  )

(defn formaNestanak [vrste]  
   [:form { :method "post" :action "/add" :id "fileForm" :enctype "multipart/form-data"}
     [:div {:class "form-group"} 
      [:label {:for "vrsta"}[:span {:class "req"}]"Vrsta životinje:"]   
      [:select {:name "vrsta" :class "form-control"}
       (map (fn [vrsta]
                 [:option {:value (:id vrsta) } (:naziv vrsta)]) vrste)]
      ]
     [:div {:class "form-group"}
       [:label {:for "rasa"}[:span {:class "req"}]"Rasa:"] 
       [:input {:class "form-control" :type "text" :name "rasa" :id "rasa"}]
      ]
     
     [:div {:class "form-group"}   
        [:label {:for "imeZivotinje"}[:span {:class "req"}]"Ime:"]
        [:input {:class "form-control" :type "text" :name "ime" :id "ime"}]
     ]
     [:div {:class "form-group"}
	     [:label {:for "pol"}[:span {:class "req"}] "Pol:"] [:br]
	     [:input {:type "radio"  :id "radio-1" :name "pol" :value "M"}]
      [:label {:for "radio-1"}"Muški"] [:br]
	     [:input {:type "radio" :id "radio-2" :name "pol" :value "Z"}]
	     [:label {:for "radio-2"}"Ženski"]
     ]
     [:div {:class "form-group"}
       [:label {:for "bojaDlake"}[:span {:class "req"}] "Boja:"]
       [:input {:class "form-control" :type "text" :name "bdlaka" :id "bdlaka" :placeholder "" :required "true"}]  
     ]
     [:div {:class "form-group"}
       [:label {:for "vrstaDlake"}[:span {:class "req"}] "Vrsta dlake:"] 
       [:input {:class "form-control" :type "text" :name "vdlaka" :id "vdlaka" :placeholder ""}]  
     ]
     [:div {:class "form-group"}
       [:label {:for "brojCipa"}[:span {:class "req"}] "Broj cipa:"]
       [:input {:class "form-control" :type "text" :name "brcip" :id "brcip" :placeholder ""}] 
     ]
    [:div {:class "form-group"}

    [:label {:for "sterilisana"}[:span {:class "req"}] "Sterilisana:"] [:br]
    [:input {:type "radio" :id "radio-11" :name "sterilisana" :value "Da"}]
    [:label {:for "radio-11"}"Da"][:br]
    [:input {:type "radio" :id "radio-22" :name "sterilisana" :value "Ne"}]
    [:label {:for "radio-22"}"Ne"]
    ]
    [:div {:class "form-group"}
      [:label {:for "mestoNestanka"}[:span {:class "req"}] "Mesto nestanka:"]
      [:input {:class "form-control" :type "text" :name "mestonestanka" :id "pobelezja"}] 
    ]
     [:div {:class "form-group"}
       [:label {:for "kontakt"}[:span {:class "req"}] "Kontakt:"]
       [:input {:class "form-control" :type "text" :name "kontakt" :id "kontakt" :placeholder "" :required "true"}] 
     ]
      [:div {:class "form-group"}
       [:label {:for "sifra"}[:span {:class "req"}] "Šifra za vaš oglas:"]
       [:input {:class "form-control" :type "text" :name "sifra" :id "sifra" :placeholder "" :required "true"}] 
     ]
    [:div {:class "form-group"}
      [:label {:for "posebnaObelezja"}[:span {:class "req"}] "Posebna obeležja:"] 
      [:input {:class "form-control" :type "text" :name "pobelezja" :id "pobelezja" :placeholder "Navesti ukratko"}]  
    ]
    [:img {:id "uploadPreview" :src (str "img/" "gif.gif") :class "" :width "250px" :height "200px"}][:br]
    [:div {:class "form-group"}
    [:input {:type "file" :id "imglink" :name "file" :size "20"}]
    ]
    [:div {:class "form-group"}
      [:input {:class "btn btn-success" :type "submit" :name "prijava_nestanak" :value "Prijavi nestanak"}]
    ]
]
  )

(defn formaIzmena [vrste nestanak1]  
 [:div
  (map 
      (fn [nestanak]
  [:div
   (form/form-to  [:post "/izmena"]
    (form/hidden-field "nid" (:id nestanak)) 
    (form/hidden-field "zid" (:zid nestanak)) 
    [:div {:class "form-group"} 
      [:label {:for "vrsta"}[:span {:class "req"}]"Vrsta životinje:"]   
      [:select {:name "vrsta" :class "form-control"}
       (map (fn [vrsta]
         [:option  (if (= (:id vrsta) (:vrstaid nestanak)) (do {:value (:id vrsta) :selected "selected"}) {:value (:id vrsta)}) (:naziv vrsta)]) vrste)]
      ]
     [:div {:class "form-group"}
       [:label {:for "rasa"}[:span {:class "req"}]"Rasa:"] 
       [:input {:class "form-control" :type "text" :name "rasa" :id "rasa" :value (:rasa nestanak)}]
      ]
     [:div {:class "form-group"}   
        [:label {:for "imeZivotinje"}[:span {:class "req"}]"Ime:"]
        [:input {:class "form-control" :type "text" :name "ime" :id "ime" :value (:ime nestanak)} ]
     ]
     [:div {:class "form-group"}
	     [:label {:for "pol"}[:span {:class "req"}] "Pol:"] [:br]
	     [:input {:type "radio"  :id "radio-1" :name "pol" :value "M"  :checked (if (= "M" (:pol nestanak ))  "true")}]
	     [:label {:for "radio-1"}"Muški"]
      [:br][:input {:type "radio" :id "radio-2" :name "pol" :value "Z" :checked (if (= "Z" (:pol nestanak ))  "true")}]
      [:label {:for "radio-2"}"Ženski"]
	     
     ]
     [:div {:class "form-group"}
       [:label {:for "bojaDlake"}[:span {:class "req"}] "Boja:"]
       [:input {:class "form-control" :type "text" :name "bdlaka" :id "bdlaka" :placeholder "" :required "true" :value (:bdlake nestanak)}]  
     ]
     [:div {:class "form-group"}
       [:label {:for "vrstaDlake"}[:span {:class "req"}] "Vrsta dlake:"] 
       [:input {:class "form-control" :type "text" :name "vdlaka" :id "vdlaka" :placeholder "" :value (:vdlake nestanak)}]  
     ]
     [:div {:class "form-group"}
       [:label {:for "brojCipa"}[:span {:class "req"}] "Broj cipa:"]
       [:input {:class "form-control" :type "text" :name "brcip" :id "brcip" :placeholder "" :value (:brcipa nestanak)}] 
     ]
    [:div {:class "form-group"}

    [:label {:for "sterilisana"}[:span {:class "req"}] "Sterilisana:"] [:br]
    [:input {:type "radio" :id "radio-11" :name "sterilisana" :value "Da" :checked (if (= "Da" (:ster nestanak ))  "true")}]
    [:label {:for "radio-11"}"Da"]
    [:br]
    [:input {:type "radio" :id "radio-22" :name "sterilisana" :value "Ne" :checked (if (= "Ne" (:ster nestanak ))  "true")}]
    [:label {:for "radio-22"}"Ne"]
    ]
    [:div {:class "form-group"}
      [:label {:for "mestoNestanka"}[:span {:class "req"}] "Mesto nestanka:"]
      [:input {:class "form-control" :type "text" :name "mestonestanka" :id "mestonestanka" :value  (:mesto nestanak)}] 
    ]
     [:div {:class "form-group"}
       [:label {:for "kontakt"}[:span {:class "req"}] "Kontakt:"]
       [:input {:class "form-control" :type "text" :name "kontakt" :id "kontakt" :placeholder "" :required "true" :value (:kontakt nestanak)} ] 
     ]
      [:div {:class "form-group"}
       [:label {:for "sifra"}[:span {:class "req"}] "Šifra za vaš oglas:"]
       [:input {:class "form-control" :type "text" :name "sifra" :id "sifra" :placeholder "" :required "true" :value (:sifra nestanak)} ] 
     ]
    [:div {:class "form-group"}
      [:label {:for "posebnaObelezja"}[:span {:class "req"}] "Posebna obeležja:"] 
      [:input {:class "form-control" :type "text" :name "pobelezja" :id "pobelezja" :value (:pobelezja nestanak)} ]  
    ]
    (form/hidden-field "imgStara" (:slika nestanak)) 
    [:div {:class "form-group"}
    [:img {:id "uploadPreview" :src (str "/img/zivotinje/" (:slika nestanak)) :class "" :width "250px" :height "200px"}][:br]
    ]
    [:div {:class "form-group"}
      [:input {:class "btn btn-success" :type "submit" :name "nestanak" :value "Izmeni nestanak"}]
    ])
   ])
      nestanak1)
]
  )

(defn nestanak [id]
  [:section {:id "portfolio"}
      [:div {:class "container wow fadeIn"}
        [:div {:class "section-header"}
          [:h3 {:class "section-title"} (if (= id nil) (do "Prijava nestanka") "Izmena nestanka")]
          ]
        [:div {:class "container wow fadeInUp"}
[:div {:class "container"}
  [:div {:class "row"}
        [:div {:class "col-md-10"}
(if (= id nil) (do (formaNestanak (db/vrstaZivotinje)))
  (formaIzmena (db/vrstaZivotinje) (db/vratiNestanak id)))

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
        [:div {:class "row" :id "portfolio-wrapper"}
         (map 
           (fn [oglas]           
              [:div {:class "col-lg-3 col-md-6 portfolio-item filter-app" :style "margin:5px;padding:10px;"}
        [:img {:src (str "img/zivotinje/" (:slika oglas)) :width "110%" :height "100%"}]
         
        [:div {:class "details"}
        [:div {:class "row portfolio-item" :style "padding:10px;"}
        [:div {:class "col" :style "width:60%"}
                [:h4 (:ime oglas) ] 
                [:span (str (:vrsta oglas) " " (:rasa oglas))] 
                [:h4 (str "Lokacija: " (:mesto oglas)) ]
                ]
        [:div {:class "col"  :style "width:40%"}
        [:form { :method "get" :action (str "/pregled/" (:id oglas)) :id "fileForm"}
        [:input {:class "form-control" :type "hidden" :name "idnestanka" :id "idnestanka" :value (:id oglas)}] 
        [:input {:class "btn" :type "submit" :name "otvori" :value "Prikaži"}]

        ]]
        ]
          ]]
             ) (db/vratioglase))
         ]
        ]
   ]
)

(defn pregled [id]
  [:div
  [:section {:id "portfolio"}
     [:div {:class "container wow fadeIn"}
      (map (fn [nestanak] 
      [:div {:class "row"}
       [:div {:class "col-lg-6 col-md-6"}
        [:h4 "NESTALA ŽIVOTINJA"]
          [:img {:src (str "/img/zivotinje/" (:slika nestanak)) :height "300em"}]
              ]
      [:div {:class "col-lg-6 col-md-6"}
        [:div {:class "details"}
         [:h5 "Informacije:"]
           [:h6 (str (:vrsta nestanak) " " (:ime nestanak))]           
           [:h6 (str "Rasa: " (:rasa nestanak)) ] 
           [:h6 (str "Pol: " (:pol nestanak)) ] 
           [:h6 (str "Status: " (:status nestanak)) ] 
           [:h6 (str "Boja dlake: " (:bdlake nestanak)) ] 
           [:h6 (str "Vrsta dlake: " (:vdlake nestanak)) ] 
           [:h6 (str "Posebna obeležja: " (:pobelezja nestanak)) ] 
           [:h6 (str "Broj čipa: " (:brcipa nestanak)) ] 
           [:h6 (str "Kontakt: " (:kontakt nestanak)) ] 
           [:h6 (str "Datum prijave: " (:datum nestanak)) ] 
           [:h6 (str "Lokacija: " (:mesto nestanak)) ]
          ]
        [:h5 "Akcije:"]
                [:div {:class "row"}
                 
         [:div {:class "col-lg-6 col-md-6"}
        [:form {:action "/delete" :method "post"}
         [:input {:type "hidden" :name "id" :value (:id nestanak)}]
         [:input {:type "hidden" :name "zid" :value (:zid nestanak)}]
         [:input {:type "hidden" :name "sifraprava" :value (:sifra nestanak)}]
         [:div {:class "form-group"}
          [:label {:for "sifra"}[:span {:class "req"}] "Šifra za brisanje oglasa:"] 
          [:input {:class "form-control" :type "text" :name "sifra" :required "true" :placeHolder "šifra oglasa"}]
          ]
         [:input {:type "submit" :class "btn btn-get-started" :name "brisanje" :value "Obrišite oglas"}]
         ]
        ]
         [:div {:class "col-lg-6 col-md-6"}
      [:form {:action (str "/izmena/" (:id nestanak)) :method "get"}
       [:input {:type "hidden" :name "id" :value (:id nestanak)}]
       [:input {:type "hidden" :name "zid" :value (:zid nestanak)}]
       [:input {:type "hidden" :name "sifraprava" :value (:sifra nestanak)}]
       [:div {:class "form-group"}
          [:label {:for "sifra"}[:span {:class "req"}] "Šifra za izmenu oglasa:"] 
          [:input {:class "form-control" :type "text" :name "sifra" :required "true" :placeHolder "šifra oglasa"}]
          ]
         [:input {:type "submit" :class "btn btn-get-started" :name "brisanje" :value "Izmenite oglas"}]
         ]
        ]
         ] 
        ]
      ]
             ) (db/vratiNestanak id))
  
]
]]
  )
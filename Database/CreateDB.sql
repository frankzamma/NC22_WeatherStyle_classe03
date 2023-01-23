drop database if exists weatherstyle;

CREATE DATABASE weatherstyle;

/*
    Raffaele
    UTENTE (ID, nome, cognome, dataNascita, cittaNascita, IDguardaroba*)
    CITTA (ID, nome, latit, longit)
    SALVARE (IDutente, IDcitta)
    SUGGERIMENTO (ID, data, valutazione, IDutente*,IDcitta*, IDoutfit*)

    Annalaura
    METEO(IDsuggerimento, temperatura, meteo, stagione)
    OUTFIT (ID, nome)
    CAPOABBIGLIAMENTO (ID, nome, categoria, stagione, colore, materiale, immagine, IDguardaroba*)
    COMPORRE (IDoutfit, IDcapoAbbigliamento)

    Angelo
    GUARDAROBA (ID, nome, numeroCapi)
    RICHIESTAPROMOZIONE (ID, tematiche, esperienze, IDutente, IDadmin*)
    ADMIN (ID, nome, cognome)

    Francesco
    POST (ID, data, titolo, descrizione, IDutente*)
    ECOLOGISTA (IDutente)
    EVENTO (ID, data, luogo, obiettivo, IDutente*)


    */
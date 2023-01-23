drop database if exists weatherstyle;

CREATE DATABASE weatherstyle;

use weatherstyle;

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
    RICHIESTAPROMOZIONE (ID, tematiche, esperienze, IDutente*, IDadmin*)
    ADMIN (ID, nome, cognome)
*/
    CREATE TABLE Guardaroba (
        ID INT PRIMARY KEY,
        nome VARCHAR(30) NOT NULL,
        numeroCapi INT NOT NULL
    );

    CREATE TABLE Amministratore (
        ID INT PRIMARY KEY,
        nome VARCHAR(30) NOT NULL,
        cognome VARCHAR(30) NOT NULL,
    );

    CREATE TABLE RichiestaPromozione (
        ID INT PRIMARY KEY,
        tematiche VARCHAR(50) NOT NULL,
        esperienze VARCHAR(250) NOT NULL,
        stato VARCHAR(15) NOT NULL,
        FOREIGN KEY (IDutente)
            REFERENCES Utente(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE,
        FOREIGN KEY (IDadmin)
            REFERENCES Amministratore(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE
    );
/*

    Francesco
    POST (ID, data, titolo, descrizione, IDutente*)
    ECOLOGISTA (IDutente)
    EVENTO (ID, data, luogo, obiettivo, IDutente*)


    */
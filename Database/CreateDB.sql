drop database if exists weatherstyle;

CREATE DATABASE weatherstyle;

use weatherstyle;

/*
    Raffaele
    UTENTE (ID, nome, cognome, dataNascita, cittaNascita, IDguardaroba*)
    CITTA (ID, nome, latit, longit)
    SALVARE (IDutente, IDcitta)
    SUGGERIMENTO (ID, data, valutazione, IDutente*,IDcitta*, IDoutfit*)
*/

    CREATE TABLE Utente (
        ID INT PRIMARY KEY,
        nome VARCHAR(30) NOT NULL,
        cognome VARCHAR(30) NOT NULL,
        dataNascita DATE NOT NULL,
        cittaNascita VARCHAR(30) NOT NULL,
        IDguardaroba INT,
        FOREIGN KEY (IDguardaroba)
            REFERENCES Guardaroba(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE
    );

    CREATE TABLE Citta (
        ID INT PRIMARY KEY,
        nome VARCHAR(30) NOT NULL,
        latitudine VARCHAR(100) NOT NULL,
        longitudine VARCHAR(100) NOT NULL
    );

    CREATE TABLE Salvare (
        IDutente INT,
        IDcitta INT,
        FOREIGN KEY (IDutente)
            REFERENCES Utente(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE,
        FOREIGN KEY (IDcitta)
            REFERENCES Citta(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE,
        PRIMARY KEY(IDutente, IDcitta)
    );

    CREATE TABLE Suggerimento (
        ID INT PRIMARY KEY,
        dataSuggerimento DATE NOT NULL,
        IDutente INT,
        FOREIGN KEY (IDutente)
            REFERENCES Utente(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE,
        IDcitta INT,
        FOREIGN KEY (IDcitta)
            REFERENCES Citta(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE,
        IDoutfit INT,
        FOREIGN KEY (IDoutfit)
            REFERENCES Outfit(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE
    );

/*

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
        IDutente INT,
        FOREIGN KEY (IDutente)
            REFERENCES Utente(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE,
        IDadmin INT,
        FOREIGN KEY (IDadmin)
            REFERENCES Amministratore(ID)
                ON UPDATE CASCADE
                ON DELETE CASCADE
    );
/*

    Francesco
    ECOLOGISTA (IDutente)
    EVENTO (ID, data, luogo, obiettivo, IDutente*)


    */
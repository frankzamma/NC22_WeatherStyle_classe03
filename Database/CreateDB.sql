drop database if exists weatherstyle;

CREATE DATABASE weatherstyle;

use weatherstyle;

    CREATE TABLE Guardaroba (
        ID INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(30) NOT NULL,
        numeroCapi INT NOT NULL
    );

    CREATE TABLE Utente (
        ID INT PRIMARY KEY AUTO_INCREMENT,
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
        ID INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
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

    CREATE TABLE Outfit (
        ID INT PRIMARY KEY AUTO_INCREMENT,
        nome varchar (30) NOT NULL
    );

    CREATE TABLE Suggerimento (
        ID INT PRIMARY KEY AUTO_INCREMENT,
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

    CREATE TABLE Meteo (
        IDsuggerimento INT,
        FOREIGN KEY (IDsuggerimento)
            REFERENCES Suggerimento(ID)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
        temperatura INT NOT NULL,
        meteo VARCHAR (30) NOT NULL,
        stagione VARCHAR (20) NOT NULL
    );

    CREATE TABLE CapoAbbigliamento (
        ID INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR (50) NOT NULL,
        categoria VARCHAR (10) NOT NULL,
        stagione VARCHAR(20) NOT NULL,
        colore VARCHAR(10) NOT NULL,
        materiale VARCHAR(15) NOT NULL,
        immagine VARCHAR(60) NOT NULL,
        IDguardaroba INT,
            FOREIGN KEY (IDguardaroba)
            REFERENCES Guardaroba(ID)
            ON UPDATE CASCADE
            ON DELETE CASCADE
    );

    CREATE TABLE Comporre (
        IDoutfit INT,
        FOREIGN KEY (IDoutfit)
            REFERENCES Outfit(ID)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
        IDcapoAbbigliamento INT,
        FOREIGN KEY (IDcapoAbbigliamento)
            REFERENCES CapoAbbigliamento(ID)
            ON UPDATE CASCADE
            ON DELETE CASCADE
    );

    CREATE TABLE Amministratore (
        ID INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(30) NOT NULL,
        cognome VARCHAR(30) NOT NULL
    );

    CREATE TABLE RichiestaPromozione (
        ID INT PRIMARY KEY AUTO_INCREMENT,
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

    CREATE TABLE Ecologista(
        IDutente INT,
        FOREIGN KEY (IDutente)
            REFERENCES Utente(ID)
            ON UPDATE CASCADE
            ON DELETE CASCADE
    );

    CREATE TABLE Evento (
        ID INT PRIMARY KEY AUTO_INCREMENT,
        data DATE NOT NULL,
        luogo VARCHAR(60) NOT NULL,
        obiettivo VARCHAR(250),
        IDutente INT,
        FOREIGN KEY (IDutente)
            REFERENCES Utente(ID)
            ON UPDATE CASCADE
            ON DELETE CASCADE
    );


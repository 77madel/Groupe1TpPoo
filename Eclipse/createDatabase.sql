-- Paiement
CREATE TABLE Paiement (
    idPaiement INT PRIMARY KEY,
    montant INT,
    modePaiement VARCHAR(50),
    datePaiement DATE
   );


-- Pays
CREATE TABLE Pays (
    idPays INT PRIMARY KEY,  
    nom VARCHAR(100)  
);

-- Vol

CREATE TABLE Vol (
    idVol INT PRIMARY KEY AUTO_INCREMENT,
    villeDeDepart DATE,
    villeDArrive DATE,
    dateDeDepart DATE,
    dateDArrive DATE,
    nombreDEscale INT,
    nombreDePlaceDispo INT,
    tarif INT
);


-- Categorie

CREATE TABLE Categorie (
    idCategorie INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(30)
);


-- Personne

CREATE TABLE Personne (
    idPersonne INT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255),
    numeroDeTelephone VARCHAR(20),
    dateDeNaissance DATE,
    motDePasse VARCHAR(255)
);

-- Passager

CREATE TABLE Passager (
    idPersonne INT,
    FOREIGN KEY (idPersonne) REFERENCES Personne(idPersonne)
);


-- Admin

CREATE TABLE Admin (
    idPersonne INT,
    FOREIGN KEY (idPersonne) REFERENCES Personne(idPersonne)
);




-- Compagnie aerienne

CREATE TABLE Compagnie(
    idCompagnie int AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY (idAdmin) REFERENCES Admin(idAdmin),
    nomCompagnie varchar(30),
    nombreDAvion varchar(30),
    motDePasse varchar(100),
    siteWeb int,
    idAdmin int
);

-- Avion

CREATE TABLE Avion(
    immatriculation  varchar(30) PRIMARY KEY,
    capacite INT,
    nom VARCHAR(30),
    modele VARCHAR(30),
    idCompagnie INT,
    FOREIGN KEY (idCompagnie) REFERENCES  Compagnie(idCompagnie)
);


-- Ville
CREATE TABLE ville(
    idVille int primary key AUTO_INCREMENT,
    idPays int,
    Nom varchar(25),
    FOREIGN KEY (idPays) REFERENCES Pays(idPays)
);

-- Aeroport

CREATE TABLE Aeroport (
    idAeroport INT PRIMARY KEY,
    idVille INT,
    nomAeroport VARCHAR(30),
    FOREIGN KEY (idVille) REFERENCES Ville(idVille)
);



-- Escale
CREATE TABLE Escale(
    idVille INT,
    idVol INT ,
    immatriculation VARCHAR(30),
    dateEtHeure DATE,
    constraint pkescale primary key(idVille,idVol,immatriculation), 
    FOREIGN KEY (idVille) REFERENCES Ville(idVille),
    FOREIGN KEY (idVol) REFERENCES Vol(idVol),
    FOREIGN KEY (immatriculation) REFERENCES Avion(immatriculation)
);



-- Reservation
CREATE TABLE Reservation (
    idReservation INT PRIMARY KEY AUTO_INCREMENT,
    idPaiement INT,
    idPassager INT,
    dateReservation DATE,
    nombreDePassager INT,
    status VARCHAR(20),
    FOREIGN KEY (idPassager) REFERENCES Passager(idPassager),
    FOREIGN KEY (idPaiement) REFERENCES Paiement(idPaiement)
);


-- InfoPassager

CREATE TABLE infoPassager (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idReservation INT,
    idVol INT,
    idCategorie INT,
    prenomPassagerEtranger VARCHAR(30),
    nomPassagerEtranger VARCHAR(30),
    prenomPassagerEtranger VARCHAR(30),
    numeroPasseport VARCHAR(30),
    FOREIGN KEY (idReservation) REFERENCES Reservation(idReservation),
    FOREIGN KEY (idVol) REFERENCES Vol(idVol),
    FOREIGN KEY (idCategorie) REFERENCES Categorie(idCategorie)
);




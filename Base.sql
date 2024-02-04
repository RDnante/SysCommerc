create database syscom;

create table service (
    id_service serial primary key,
    nom varchar(30),
    mot_passe varchar(30)
);

insert into service values (default,'economique','eco123');
insert into service values (default,'securite','secu123');

create table categorie (
    id_categorie serial primary key,
    nom varchar(40)
);

create table article (
    id_article serial primary key,
    id_categorie int references categorie(id_categorie),
    nom varchar(40)
);

insert into article values (default,1,'stylo');
insert into article values  (default,2,'couteau');

create table service_besoin (
    id_servicebesoin serial primary key,
    id_service int references service(id_service),
    id_article int references article(id_article),
    quantite decimal,
    date date default current_date,
    status int
);

create table fournisseur (
    id_fournisseur serial primary key,
    nom varchar(50),
    mdp varchar(50)
);

insert into fournisseur values (default,'jumbo','1234');
insert into fournisseur values (default,'cosmos','4321');

create table stock_fournisseur (
    id_stock_fournisseur serial primary key,
    id_fournisseur int references fournisseur(id_fournisseur),
    id_article int references article(id_article),
    quantite decimal,
    prix_unitaire decimal
);

insert into stock_fournisseur values (default,1,1,150,340);

create table bonDeCommande(
    idBonDeCommande serial primary key,
    nom varchar(50),
    date varchar(50),
    livraisonPartielle boolean,
    modePaiement varchar(50),
    categorie varchar(50),
    designation varchar(50),
    quantite decimal,
    tva decimal,
    ttc decimal
);

CREATE TABLE Lieux (
    ID_Lieu serial primary key,
    Nom_endroit VARCHAR(100),
    Latitude VARCHAR,
    Longitude VARCHAR
);

CREATE TABLE Immobilisations (
    ID_Immobilisation serial primary key,
    Date DATE default current_date,
    prix decimal,
    Compte_comptable VARCHAR(20),
    Numero VARCHAR(20),
    Type VARCHAR(50),
    Marque VARCHAR(50),
    Modele VARCHAR(50),
    Numero_serie VARCHAR(50),
    Description TEXT,
    Taux_amortissement DECIMAL(5,2),
    Neuf BOOLEAN,
    Utilisable BOOLEAN,
    Methode_amortissement VARCHAR(50),
    ID_Lieu INT,
    FOREIGN KEY (ID_Lieu) REFERENCES Lieux(ID_Lieu)
);

insert into Lieux values (default,'andoharanofotsy','latitude','longitude');
insert into Immobilisations values (default,default,20000000,'101',01,'voiture','toyota','supra','1234','stutututu',20,true,true,'linaire',1);

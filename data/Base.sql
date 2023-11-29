create database syscom;
\c syscom
create table service (
    id_service serial primary key,
    nom varchar(30),
    mot_passe varchar(30)
);

create table categorie (
    id_categorie serial primary key,
    nom varchar(40)
);

create table article (
    id_article serial primary key,
    id_categorie int references categorie(id_categorie),
    nom varchar(40)
);

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
    nom varchar(50)
);


create table stock_fournisseur (
    id_stock_fournisseur serial primary key,
    id_fournisseur int references fournisseur(id_fournisseur),
    id_article int references article(id_article),
    quantite decimal,
    prix_unitaire decimal
);

create table commande(
    idCommande serial primary key,
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

create table bonDeCommande (
    idBonDeCommande serial primary key,
    id_fournisseur int references fournisseur(id_fournisseur),
    dateConfirmation DATE DEFAULT CURRENT_DATE
);

create table bonDeCommande_commandes (
    idBonDeCommande_commande serial primary key,
    idBonDeCommande int references  bonDeCommande(idBonDeCommande),
    idCommande int references commande(idCommande)
);

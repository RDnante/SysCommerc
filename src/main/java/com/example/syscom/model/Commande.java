package com.example.syscom.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")
    Integer numero;
    @Column(name = "nom")
    String nom;
    @Column(name = "date")
    String date;
    @Column(name = "livraisonPartielle")
    Boolean livraisonPartielle;
    @Column(name = "modePaiement")
    String modePaiement;
    @Column(name = "categorie")
    String categorie;
    @Column(name = "designation")
    String designation;
    @Column(name = "quantite")
    double quantite;
    @Column(name = "prixUnitaire")
    double prixUnitaire;
    @Column(name = "tva")
    double tva;
    @Column(name = "ttc")
    double ttc;
    @Column(name = "idServiceBesoin")
    Integer idServiceBesoin;
    public Commande(Integer numero, String nom, String date, Boolean livraisonPartielle, String modePaiement,
            String categorie, String designation, double quantite, double prixUnitaire, double tva, double ttc,
            Integer idServiceBesoin) {
        this.numero = numero;
        this.nom = nom;
        this.date = date;
        this.livraisonPartielle = livraisonPartielle;
        this.modePaiement = modePaiement;
        this.categorie = categorie;
        this.designation = designation;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.tva = tva;
        this.ttc = ttc;
        this.idServiceBesoin = idServiceBesoin;
    }
    public Commande() {
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Boolean getLivraisonPartielle() {
        return livraisonPartielle;
    }
    public void setLivraisonPartielle(Boolean livraisonPartielle) {
        this.livraisonPartielle = livraisonPartielle;
    }
    public String getModePaiement() {
        return modePaiement;
    }
    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public double getTva() {
        return tva;
    }
    public void setTva(double tva) {
        this.tva = tva;
    }
    public double getTtc() {
        return ttc;
    }
    public void setTtc(double ttc) {
        this.ttc = ttc;
    }
    public Integer getIdServiceBesoin() {
        return idServiceBesoin;
    }
    public void setIdServiceBesoin(Integer idServiceBesoin) {
        this.idServiceBesoin = idServiceBesoin;
    }
    
}

package com.example.syscom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bondecommande")
public class BonDeCommandeB {
    @Id
    @Column(name = "idBonDeCommande")
    Integer idBonDeCommande;
    @Column(name = "idFournisseur")
    Integer idFournisseur;
    @Column(name = "dateConfirmation")
    String dateConfirmation;

    public BonDeCommandeB(int idBonDeCommande, int idFournisseur, String dateConfirmation) {
        this.idBonDeCommande = idBonDeCommande;
        this.idFournisseur = idFournisseur;
        this.dateConfirmation = dateConfirmation;
    }

    public BonDeCommandeB() {
    }

    public int getIdBonDeCommande() {
        return idBonDeCommande;
    }

    public void setIdBonDeCommande(int idBonDeCommande) {
        this.idBonDeCommande = idBonDeCommande;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getDateConfirmation() {
        return dateConfirmation;
    }

    public void setDateConfirmation(String dateConfirmation) {
        this.dateConfirmation = dateConfirmation;
    }
}

package com.example.syscom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BonDeCommande_Commandes {
    @Id
    @Column(name = "idBonDeCommande_Commande")
    Integer idBonDeCommande_Commande;
    @Column(name = "idBonDeCommande")
    Integer idBonDeCommande;
    @Column(name = "idCommande")
    Integer idCommande;

    public BonDeCommande_Commandes(int idBonDeCommande_Commande, int idBonDeCommande, int idCommande) {
        this.idBonDeCommande_Commande = idBonDeCommande_Commande;
        this.idBonDeCommande = idBonDeCommande;
        this.idCommande = idCommande;
    }
    public BonDeCommande_Commandes() {
    }
    public int getIdBonDeCommande_Commande() {
        return idBonDeCommande_Commande;
    }
    public void setIdBonDeCommande_Commande(int idBonDeCommande_Commande) {
        this.idBonDeCommande_Commande = idBonDeCommande_Commande;
    }
    public int getIdBonDeCommande() {
        return idBonDeCommande;
    }
    public void setIdBonDeCommande(int idBonDeCommande) {
        this.idBonDeCommande = idBonDeCommande;
    }
    public int getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }



    
}
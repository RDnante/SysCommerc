package com.example.syscom.model;

import java.util.List;

public class BonDeCommande {
    List<Commande> commandes;
    double sommePrixTtc;
    Boolean status;
    public BonDeCommande(List<Commande> commandes, double sommePrixTtc) {
        this.commandes = commandes;
        this.sommePrixTtc = sommePrixTtc;
    }
    public BonDeCommande() {
    }
    public List<Commande> getCommandes() {
        return commandes;
    }
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    public double getSommePrixTtc() {
        return sommePrixTtc;
    }
    public void setSommePrixTtc(double sommePrixTtc) {
        this.sommePrixTtc = sommePrixTtc;
    }
}

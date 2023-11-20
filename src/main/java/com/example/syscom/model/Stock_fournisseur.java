package com.example.syscom.model;

import javax.persistence.*;

@Entity
@Table(name = "stock_fournisseur")
public class Stock_fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_stock_fournisseur;

    @Column(name = "id_fournisseur")
    Integer id_fournisseur;

    @Column(name = "id_article")
    Integer id_article;

    @Column(name = "quantite")
    Double quantite;

    @Column(name = "prix_unitaire")
    Double prix_unitaire;

    public Stock_fournisseur() {
    }

    public Integer getId_stock_fournisseur() {
        return id_stock_fournisseur;
    }

    public void setId_stock_fournisseur(Integer id_stock_fournisseur) {
        this.id_stock_fournisseur = id_stock_fournisseur;
    }

    public Integer getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(Integer id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
}

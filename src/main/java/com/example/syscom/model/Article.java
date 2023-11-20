package com.example.syscom.model;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_article;

    @Column(name = "id_categorie")
    Integer id_categorie;

    @Column(name = "nom")
    String nom;

    @Transient
    Categorie categorie;

    public Article() {
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Integer id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}

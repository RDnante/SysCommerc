package com.example.syscom.model;

import com.example.syscom.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Column(name = "idunite")
    Integer idunite;

    @Column(name = "idtypegestion")
    Integer idtypegestion;

    @Transient
    Categorie categorie;

    public Article(Integer id_article, Integer id_categorie, String nom, Integer idunite, Integer idtypegestion,
            Categorie categorie) {
        this.id_article = id_article;
        this.id_categorie = id_categorie;
        this.nom = nom;
        this.idunite = idunite;
        this.idtypegestion = idtypegestion;
        this.categorie = categorie;
    }

    public Article() {
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Integer getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Integer id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getIdunite() {
        return idunite;
    }

    public void setIdunite(Integer idunite) {
        this.idunite = idunite;
    }

    public Integer getIdtypegestion() {
        return idtypegestion;
    }

    public void setIdtypegestion(Integer idtypegestion) {
        this.idtypegestion = idtypegestion;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    
    
}

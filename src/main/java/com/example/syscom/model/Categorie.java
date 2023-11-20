package com.example.syscom.model;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_categorie;

    @Column(name = "nom")
    String nom;

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

    public Categorie() {
    }
}

package com.example.syscom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPoste;
    @Column(name = "nom")
    String nom;
    
    public Poste(Integer idPoste, String nom) {
        this.idPoste = idPoste;
        this.nom = nom;
    }
    public Poste() {
    }
    public Integer getIdPoste() {
        return idPoste;
    }
    public void setIdPoste(Integer idPoste) {
        this.idPoste = idPoste;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}

package com.example.syscom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unite")
public class Unite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idunite;
    @Column(name = "libelle")
    String libelle;
    
    public Unite() {
    }
    public Unite(Integer idunite, String libelle) {
        this.idunite = idunite;
        this.libelle = libelle;
    }
    public Integer getIdunite() {
        return idunite;
    }
    public void setIdunite(Integer idunite) {
        this.idunite = idunite;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}

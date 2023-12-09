package com.example.syscom.model;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class ServiceC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idService;
    @Column(name = "nom")
    String nom;

    @Column(name = "mot_passe")
    String mot_passe;

    public ServiceC() {
    }
    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }
}

package com.example.syscom.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeGestion")
public class TypeGestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IdTypeGestion;
    @Column(name = "libelle")
    String libelle;
    @Column(name = "typeGestion")
    String typeGestion;
    
    public TypeGestion() {
    }
    public TypeGestion(Integer idTypeGestion, String libelle, String typeGestion) {
        IdTypeGestion = idTypeGestion;
        this.libelle = libelle;
        this.typeGestion = typeGestion;
    }
    public Integer getIdTypeGestion() {
        return IdTypeGestion;
    }
    public void setIdTypeGestion(Integer idTypeGestion) {
        IdTypeGestion = idTypeGestion;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getTypeGestion() {
        return typeGestion;
    }
    public void setTypeGestion(String typeGestion) {
        this.typeGestion = typeGestion;
    }
    
    
}

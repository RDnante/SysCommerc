package com.example.syscom.repository;

import com.example.syscom.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {

    @Query("from fournisseur where nom = ?1")
    public Fournisseur getFournisseurByNom(String nom);
}

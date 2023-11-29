package com.example.syscom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.syscom.model.BonDeCommande_Commandes;

public interface BonDeCommande_CommandesRepository extends JpaRepository<BonDeCommande_Commandes, Integer>{
    
}

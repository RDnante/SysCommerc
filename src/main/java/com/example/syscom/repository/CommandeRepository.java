package com.example.syscom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.syscom.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    
}

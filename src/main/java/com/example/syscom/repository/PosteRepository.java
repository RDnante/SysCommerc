package com.example.syscom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.syscom.model.Poste;

public interface PosteRepository extends JpaRepository<Poste,Integer>{
    
}

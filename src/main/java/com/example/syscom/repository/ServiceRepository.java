package com.example.syscom.repository;

import com.example.syscom.model.ServiceC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<ServiceC,Integer> {
    @Query("from ServiceC where nom = ?1 and mot_passe = ?2")
    ServiceC loginServie(String nom, String mdp);

}

package com.example.syscom.repository;

import com.example.syscom.model.Service_besoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Service_besoinRepository extends JpaRepository<Service_besoin,Integer> {

    @Query("from Service_besoin where id_service = ?1")
    List<Service_besoin> findbyservice(Integer idservice);
}

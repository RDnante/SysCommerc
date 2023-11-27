package com.example.syscom.repository;

import com.example.syscom.model.ServiceC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<ServiceC,Integer> {
//    @Query("from ")
}

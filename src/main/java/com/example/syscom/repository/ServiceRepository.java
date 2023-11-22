package com.example.syscom.repository;

import com.example.syscom.model.ServiceC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceC,Integer> {
}

package com.example.syscom.repository;

import com.example.syscom.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}

package com.example.syscom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.syscom.model.Login;

public interface LoginRepository extends JpaRepository<Login,Integer> {
    @Query("from Login where password=?1")
    Login authentification(String mdp);
}

package com.example.syscom.repository;

import com.example.syscom.model.Stock_fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Stock_fournisseurRepository extends JpaRepository<Stock_fournisseur,Integer> {

    @Query("from Stock_fournisseur where id_article = ?1")
    List<Stock_fournisseur> getStockfournisseurbyIdarticle(Integer idarticle);
}

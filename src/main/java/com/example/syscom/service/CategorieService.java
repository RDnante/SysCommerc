package com.example.syscom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.Categorie;
import com.example.syscom.repository.CategorieRepository;

@Service
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public Categorie getCategorieByIdCategorie(Integer idCategorie)throws Exception{
        try {
            return categorieRepository.findById(idCategorie).get();
        } catch (Exception e) {
            throw new Exception("Error getCategorieByIdCategorie");
            // TODO: handle exception
        }
    }
}

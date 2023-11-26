package com.example.syscom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.Fournisseur;
import com.example.syscom.repository.FournisseurRepository;

@Service
public class FournisseurService {
    @Autowired 
    FournisseurRepository fournisseurRepository;

    public Fournisseur getFournisseurByIdFournisseur(Integer idFournisseur)throws Exception{
        try {
            return fournisseurRepository.findById(idFournisseur).get();
        } catch (Exception e) {
            throw new Exception("Error getFournisseurByIdFournisseur");
            // TODO: handle exception
        }
    }

    public Fournisseur getFournisseurByNom(String nom)throws Exception{
        try {
            return fournisseurRepository.getFournisseurByNom(nom);
        } catch (Exception e) {
            throw new Exception("Error getFournisseurByNom");
            // TODO: handle exception
        }
    }
}

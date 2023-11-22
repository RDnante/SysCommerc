package com.example.syscom.service;

import java.util.List;

import javax.activation.CommandObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.Article;
import com.example.syscom.model.BonDeCommande;
import com.example.syscom.model.Commande;
import com.example.syscom.model.Fournisseur;
import com.example.syscom.model.Stock_fournisseur;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.CommandeRepository;
import com.example.syscom.repository.Stock_fournisseurRepository;

@Service
public class BonDeCommandeService {
    @Autowired
    Stock_fournisseurRepository stockFournisseurRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CommandeRepository commandeRepository;

    public List<Article> getAllArticle()throws Exception{
        try {
            return articleRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error getAllArticle");
            // TODO: handle exception
        }
    } 

    public double getSomme(List<Commande> allc)throws Exception{
        try {
            double somme = 0;
            for (int i = 0; i < allc.size(); i++) {
                somme = allc.get(i).getTtc();
            }
            return somme;
        } catch (Exception e) {
            throw new Exception("Error getSomme");
            // TODO: handle exception
        }
    }

    public BonDeCommande getBonDeCommande(Integer Service)throws Exception{
        try {
            BonDeCommande bdc = new BonDeCommande();
            bdc.setCommandes((new Stock_fournisseurService()).getAllCommande(Service));
            bdc.setSommePrixTtc(getSomme(bdc.getCommandes()));
            return bdc;
        } catch (Exception e) {
            throw new Exception("Error getBonDeCommande");
            // TODO: handle exception
        }
    }

    public BonDeCommande getBonDeCommandeByFournisseur(Integer idService, Integer idFournisseur)throws Exception{
        try {
            BonDeCommande init = getBonDeCommande(idService);
            List<Commande> cs = init.getCommandes();
            for (int i = 0; i < cs.size(); i++) {
                Fournisseur f = (new FournisseurService()).getFournisseurByNom(cs.get(i).getNom());
                if (f.getId_fournisseur()!=idFournisseur) {
                    cs.remove(i);
                }
            }
            init.setCommandes(cs);
            init.setSommePrixTtc(getSomme(cs));
            return init;
        } catch (Exception e) {
            throw new Exception("Error getBonDeCommandeByFournisseur");
            // TODO: handle exception
        }
    }

    public void confirmation(BonDeCommande bdc)throws Exception{
        try {
            for (int i = 0; i < bdc.getCommandes().size(); i++) {
                commandeRepository.save(bdc.getCommandes().get(i));
            }
        } catch (Exception e) {
            throw new Exception("Error confirmation");
            // TODO: handle exception
        }
    }
}

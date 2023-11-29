package com.example.syscom.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.activation.CommandObject;

import com.example.syscom.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.Article;
import com.example.syscom.model.BonDeCommande;
import com.example.syscom.model.BonDeCommandeB;
import com.example.syscom.model.Commande;
import com.example.syscom.model.Fournisseur;
import com.example.syscom.model.Stock_fournisseur;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.BonDeCommandeBRepository;
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
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    FournisseurService fournisseurService;
    @Autowired
    Stock_fournisseurService stock_fournisseurService;
    @Autowired
    BonDeCommandeBRepository bonDeCommandeBRepository;

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
            bdc.setCommandes(stock_fournisseurService.getAllCommande(Service));
            bdc.setSommePrixTtc(getSomme(bdc.getCommandes()));
            return bdc;
        } catch (Exception e) {
            throw new Exception("Error getBonDeCommande");
            // TODO: handle exception
        }
    }

    public BonDeCommande getBonDeCommandeByFournisseur(Integer idService, Integer idFournisseur)throws Exception{
        try {
            System.out.println(12123);
            BonDeCommande init = this.getBonDeCommande(idService);
            List<Commande> cs = init.getCommandes();
            System.out.println("cs"+cs.size());
            for (int i = 0; i < cs.size(); i++) {
                Fournisseur f = fournisseurService.getFournisseurByNom(cs.get(i).getNom());
                if (f.getId_fournisseur()!=idFournisseur) {
                    cs.remove(i);
                }
            }
            init.setCommandes(cs);
            init.setSommePrixTtc(getSomme(cs));
            return init;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error getBonDeCommandeByFournisseur"+e.getCause());
            // TODO: handle exception
        }
    }

    public List<BonDeCommande> listbon(Integer idserver) {
        List<Fournisseur> listf = fournisseurRepository.findAll();
        List<BonDeCommande> dv = new ArrayList<BonDeCommande>();

        for (Fournisseur f : listf) {
            try {
                if (this.getBonDeCommandeByFournisseur(idserver,f.getId_fournisseur()).getCommandes().size() != 0) {
                    dv.add(this.getBonDeCommandeByFournisseur(idserver,f.getId_fournisseur()));
                    System.out.println("ato");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return dv;

    }

    public void confirmation(BonDeCommande bdc, Integer idFournisseur)throws Exception{
        try {
            BonDeCommandeB b = new BonDeCommandeB();
            b.setIdFournisseur(idFournisseur);
            b.setDateConfirmation(String.valueOf(LocalDate.now()));
            bonDeCommandeBRepository.save(b);
            for (int i = 0; i < bdc.getCommandes().size(); i++) {
                commandeRepository.save(bdc.getCommandes().get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error confirmation");
            // TODO: handle exception
        }
    }
}

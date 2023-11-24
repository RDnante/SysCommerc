package com.example.syscom.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.syscom.repository.Service_besoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.Article;
import com.example.syscom.model.Categorie;
import com.example.syscom.model.Commande;
import com.example.syscom.model.Fournisseur;
import com.example.syscom.model.Service_besoin;
import com.example.syscom.model.Stock_fournisseur;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.CategorieRepository;
import com.example.syscom.repository.Stock_fournisseurRepository;

@Service
public class Stock_fournisseurService {
    @Autowired
    Stock_fournisseurRepository stock_fournisseurRepository;
    @Autowired 
    ArticleRepository articleRepository;
    @Autowired
    Service_besoinService serviceBesoinService;
    @Autowired
    Service_besoinRepository serviceBesoinRepository;
    @Autowired
    CategorieRepository categorieRepository;

    public List<Stock_fournisseur> moinsDisant(Integer idService)throws Exception{
        try {
            List<Stock_fournisseur> all = new ArrayList<>();
            List<Service_besoin> allBesoin = serviceBesoinRepository.findbyservice(1);
            for (int i = 0; i < allBesoin.size(); i++) {
                Stock_fournisseur sf = stock_fournisseurRepository.getListArticleByPrixUnitaire(allBesoin.get(i).getId_article()).get(0);
                all.add(sf);
            }
            return all;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            throw new Exception("getAllPrixMora");
            // TODO: handle exception
        }
    }

    public List<Commande> getAllCommande(Integer idService)throws Exception{
        try {
            List<Stock_fournisseur> allSF = moinsDisant(idService);
            List<Commande> all = new ArrayList<>();
            for (int i = 0; i < allSF.size(); i++) {
                Commande c = new Commande();
                Article a = articleRepository.findById(allSF.get(i).getId_article()).get();
                Categorie ca = categorieRepository.findById(a.getId_categorie()).get();
                Service_besoin sb = (new Service_besoinService()).getBesoinByServiceByIdArticle(idService, a.getId_article());
                Fournisseur f = (new FournisseurService()).getFournisseurByIdFournisseur(allSF.get(i).getId_fournisseur());
                c.setNom(f.getNom());
                c.setCategorie(ca.getNom());
                c.setDate(String.valueOf(LocalDate.now()));
                c.setLivraisonPartielle(false);
                c.setModePaiement("Cheque");
                c.setDesignation(a.getNom());
                c.setQuantite(sb.getQuantite());
                c.setPrixUnitaire(allSF.get(i).getPrix_unitaire());
                double prix = sb.getQuantite()*allSF.get(i).getPrix_unitaire();
                double tva = (prix*20)/100;
                double ttc = prix + tva;
                c.setTva(tva);
                c.setTtc(ttc);
                all.add(c);
            }
            return all;
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("getAllCommande");
            // TODO: handle exception
        }
    }

    // public List<Stock_fournisseur> getAllPrixMoraByFournisseur(Integer idFournisseur)throws Exception{
    //     try {
            
    //     } catch (Exception e) {
    //         throw new Exception("getAllPrixMoraByFournisseur");
    //         // TODO: handle exception
    //     }
    // }
}

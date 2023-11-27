package com.example.syscom.service;

import com.example.syscom.model.Article;
import com.example.syscom.model.Service_besoin;
import com.example.syscom.model.Stock_fournisseur;
import com.example.syscom.model.VerifStock;
import com.example.syscom.repository.ArticleRepository;
import com.example.syscom.repository.Service_besoinRepository;
import com.example.syscom.repository.Stock_fournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Service_besoinService {
    @Autowired
    Service_besoinRepository serviceBesoinRepository;
    @Autowired
    Stock_fournisseurRepository stock_fournisseurRepository;
    @Autowired
    ArticleRepository articleRepository;

    // public int verif_besoin(Integer idservice) {
    //     int valiny = 0;

    //     return valiny;
    // }

    public List<Service_besoin> getBesoinByService(Integer idservice) {
        List<Service_besoin> valiny = new ArrayList<Service_besoin>();

        valiny = serviceBesoinRepository.findbyservice(idservice);

        return valiny;
    }

    public Service_besoin getBesoinByServiceByIdArticle(Integer idService, Integer idArticle)throws Exception{
        try {
            return serviceBesoinRepository.getServiceBesoinByIdServiceIdArticle(idService, idArticle);
        } catch (Exception e) {
            throw new Exception("Error getBesoinByServiceByIdArticle");
            // TODO: handle exception
        }
    }

    public void insertBesoin(Integer idService, Integer idArticle, double quantite )throws Exception{
        try {
            Service_besoin sb = new Service_besoin();
            sb.setId_service(idService);
            sb.setId_article(idArticle);
            sb.setQuantite(quantite);
            sb.setStatus(0);
            serviceBesoinRepository.save(sb);
        } catch (Exception e) {
            throw new Exception("insertBesoin");
            // TODO: handle exception
        }
    }

//    public List<VerifStock> summ(List<VerifStock> list) {
//        List<VerifStock> farany = new ArrayList<VerifStock>();
//        List<Article> a = articleRepository.findAll();
//
//        for (Article as : a) {
//            VerifStock vs = new VerifStock();
//            for (VerifStock v : list) {
//                if (as.getNom().equals(v.getArticle())) {
//                    vs.setNombre_besoin();
//                }
//            }
//        }
//
//    }

    public List<VerifStock> getVerifStock(Integer idservice,Integer idfournisseur) {
        List<Service_besoin> serviceBesoins = serviceBesoinRepository.findbyservice(idservice);
        List<Stock_fournisseur> stockFournisseurs = stock_fournisseurRepository.getListbyIdfournisseur(idfournisseur);
        List<VerifStock> verifStocks = new ArrayList<VerifStock>();

        for (Service_besoin s : serviceBesoins) {
            for (Stock_fournisseur f : stockFournisseurs) {
                if (s.getId_article().equals(f.getId_article())) {
                    VerifStock stock = new VerifStock();
                    Article a = articleRepository.findById(s.getId_article()).get();
                    stock.setArticle(a.getNom());
                    stock.setNombre_besoin(s.getQuantite());
                    stock.setNombre_stock(f.getQuantite());
                    stock.setPu(f.getPrix_unitaire());
                    verifStocks.add(stock);
                }
            }
        }

        return verifStocks;
    }




}

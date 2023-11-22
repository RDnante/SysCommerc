package com.example.syscom.service;

import com.example.syscom.model.Fournisseur;
import com.example.syscom.model.Proforma;
import com.example.syscom.model.Service_besoin;
import com.example.syscom.model.Stock_fournisseur;
import com.example.syscom.repository.FournisseurRepository;
import com.example.syscom.repository.Stock_fournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProformaService {
    @Autowired
    Service_besoinService serviceBesoinService;
    @Autowired
    Stock_fournisseurRepository stockFournisseurRepository;

    @Autowired
    FournisseurRepository fournisseurRepository;

    public List<Stock_fournisseur> getStock_fournisseurByBesoin(Integer idservice) {
        String valiny = null;
        List<Stock_fournisseur> stock = new ArrayList<Stock_fournisseur>();

        List<Service_besoin> service = serviceBesoinService.getBesoinByService(idservice);
        if (service.size() > 0) {
            for (Service_besoin sb : service) {
                stock.addAll(stockFournisseurRepository.getStockfournisseurbyIdarticle(sb.getId_article()));
            }
        }

        return stock;
    }

    public List<Proforma> getProforma(Integer idservice) {
        List<Proforma> listproforma = new ArrayList<Proforma>();

        List<Stock_fournisseur> doker = new ArrayList<Stock_fournisseur>();
        List<Stock_fournisseur> all = this.getStock_fournisseurByBesoin(idservice);
        List<Fournisseur> list = fournisseurRepository.findAll();

        for (Fournisseur f : list) {
            for (Stock_fournisseur s : all) {
                if (f.getId_fournisseur().equals(s.getId_fournisseur())) {
                    doker.add(s);
                }
            }
            Proforma p = new Proforma();
            p.setFournisseur(f);
            p.setListStock(doker);
            listproforma.add(p);
            doker = new ArrayList<Stock_fournisseur>();
        }

        return listproforma;
    }

}
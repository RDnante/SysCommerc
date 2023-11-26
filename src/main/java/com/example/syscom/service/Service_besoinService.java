package com.example.syscom.service;

import com.example.syscom.model.Service_besoin;
import com.example.syscom.repository.Service_besoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Service_besoinService {
    @Autowired
    Service_besoinRepository serviceBesoinRepository;

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

    




}

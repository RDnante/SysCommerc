package com.example.syscom.service;

import com.example.syscom.model.Service_besoin;
import com.example.syscom.repository.Stock_fournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProformaService {
    @Autowired
    Service_besoinService serviceBesoinService;
    @Autowired
    Stock_fournisseurRepository stockFournisseurRepository;

    public String getProforma(Integer idservice) {
        String valiny = null;

        List<Service_besoin> service = serviceBesoinService.verifBesoin(idservice);
        if (service.size() != 0) {

        }

        return valiny;
    }

}

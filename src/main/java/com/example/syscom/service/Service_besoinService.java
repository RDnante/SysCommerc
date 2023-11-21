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

    public int verif_besoin(Integer idservice) {
        int valiny = 0;

        return valiny;
    }

    public List<Service_besoin> verifBesoin(Integer idservice) {
        List<Service_besoin> valiny = new ArrayList<Service_besoin>();

        valiny = serviceBesoinRepository.findbyservice(idservice);

        return valiny;
    }




}

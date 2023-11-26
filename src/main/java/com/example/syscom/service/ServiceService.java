package com.example.syscom.service;

import java.util.List;

import com.example.syscom.repository.Service_besoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.ServiceC;
import com.example.syscom.repository.ServiceRepository;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    Service_besoinRepository serviceBesoinRepository;

    public Integer logService(ServiceC s)throws Exception{
        try {
            List<ServiceC> all = serviceRepository.findAll();
            for (int i = 0; i < all.size(); i++) {
                if (all.get(i).getIdService()==s.getIdService()) {
                    return s.getIdService();
                }
            }
            return null;
        } catch (Exception e) {
            throw new Exception("logService");
            // TODO: handle exception
        }
    }

    public Boolean logRH(ServiceC s)throws Exception{
        try {
            if (s.getIdService()==1) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            throw new Exception("logRH");
            // TODO: handle exception
        }
    }

    public List<ServiceC> getServiceWithBesoin() {
        List<ServiceC> valiny = null;
        List<Integer> idservice = serviceBesoinRepository.getIdserviceWithBesoin();

        for (Integer s : idservice) {
            ServiceC sc = serviceRepository.findById(s).get();
            valiny.add(sc);
        }

        return valiny;
    }

    
}

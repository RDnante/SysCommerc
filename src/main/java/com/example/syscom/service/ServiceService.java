package com.example.syscom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.syscom.model.ServiceC;
import com.example.syscom.repository.ServiceRepository;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

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

    
}

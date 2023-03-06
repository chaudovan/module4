package com.example.furama.service.impl;


import com.example.furama.model.Facility;
import com.example.furama.repository.IFacilityRepository;
import com.example.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository iFacilityRepository;
    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Facility findById(int id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Facility employee) {
        iFacilityRepository.save(employee);
    }

    @Override
    public void update(Facility employee) {
        iFacilityRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        iFacilityRepository.deleteById(id);
    }
}

package com.example.demo.service;

import com.example.demo.model.Smartphone;
import com.example.demo.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService{
    @Autowired
    ISmartphoneRepository smartphoneRepository;
    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }


    @Override
    public void save(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }

    @Override
    public Smartphone findById(int id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        smartphoneRepository.deleteById(id);
    }
}

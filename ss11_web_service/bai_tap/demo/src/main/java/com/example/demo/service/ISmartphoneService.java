package com.example.demo.service;

import com.example.demo.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();
    void save(Smartphone smartphone);
    Smartphone findById(int id);
    void remove(int id);
}

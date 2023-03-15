package com.example.smart_phone.service;

import com.example.smart_phone.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();
    void save(Smartphone smartphone);
    Smartphone findById(int id);
    void remove(int id);
}

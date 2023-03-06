package com.example.furama.service;

import com.example.furama.model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();
    Facility findById(int id);
    void save(Facility employee);
    void update(Facility employee);
    void deleteById(int id);
}

package com.example.furama.service;



import com.example.furama.model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    Contract findById(int id);
    void save(Contract employee);
    void update(Contract employee);
    void deleteById(int id);
}

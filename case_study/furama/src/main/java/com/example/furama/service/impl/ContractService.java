package com.example.furama.service.impl;

import com.example.furama.model.Contract;
import com.example.furama.repository.IContractReposiroty;
import com.example.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractReposiroty iContractReposiroty;
    @Override
    public List<Contract> findAll() {
        return iContractReposiroty.findAll();
    }

    @Override
    public Contract findById(int id) {
        return iContractReposiroty.findById(id).orElse(null);
    }

    @Override
    public void save(Contract employee) {
        iContractReposiroty.save(employee);
    }

    @Override
    public void update(Contract employee) {
        iContractReposiroty.save(employee);
    }

    @Override
    public void deleteById(int id) {
        iContractReposiroty.deleteById(id);
    }
}

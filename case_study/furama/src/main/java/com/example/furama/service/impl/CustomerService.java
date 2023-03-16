package com.example.furama.service.impl;

import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;
import com.example.furama.repository.ICustomerRepository;
import com.example.furama.repository.ICustomerTypeRepository;
import com.example.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer employee) {
        iCustomerRepository.save(employee);
    }

    @Override
    public void update(Customer employee) {
        iCustomerRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllName(Pageable pageable, String name) {
        return iCustomerRepository.findAllName(pageable,"%" + name + "%");
    }

    @Override
    public List<CustomerType> findAllCusType() {
        return iCustomerTypeRepository.findAll();
    }
}

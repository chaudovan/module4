package com.example.furama.service.impl;

import com.example.furama.model.Customer;
import com.example.furama.repository.ICustomerRepository;
import com.example.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
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
}

package com.example.furama.service;


import com.example.furama.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer employee);
    void update(Customer employee);
    void deleteById(int id);
}

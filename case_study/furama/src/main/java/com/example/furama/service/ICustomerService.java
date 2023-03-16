package com.example.furama.service;


import com.example.furama.model.Customer;
import com.example.furama.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer employee);
    void update(Customer employee);
    void deleteById(int id);
    Page<Customer> findAllName(Pageable pageable,String name);
    List<CustomerType> findAllCusType();
}

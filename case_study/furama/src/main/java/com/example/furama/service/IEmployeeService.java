package com.example.furama.service;

import com.example.furama.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(int id);
}

package com.example.furama.service.impl;

import com.example.furama.model.Employee;
import com.example.furama.repository.IEmployeeRepository;
import com.example.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        iEmployeeRepository.deleteById(id);
    }
}

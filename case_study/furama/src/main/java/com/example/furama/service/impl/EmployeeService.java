package com.example.furama.service.impl;

import com.example.furama.model.Division;
import com.example.furama.model.EducationDegree;
import com.example.furama.model.Employee;
import com.example.furama.model.Position;
import com.example.furama.repository.IDivisionRepository;
import com.example.furama.repository.IEducationRepository;
import com.example.furama.repository.IEmployeeRepository;
import com.example.furama.repository.IPositionRepository;
import com.example.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Autowired
    IDivisionRepository iDivisionRepository;
    @Autowired
    IEducationRepository iEducationRepository;
    @Autowired
    IPositionRepository iPositionRepository;
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

    @Override
    public List<Division> findAllDivision() {
        return iDivisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducation() {
        return iEducationRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return iPositionRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable, String name) {
        return iEmployeeRepository.findAllName(pageable, "%" + name + "%");
    }

    @Override
    public Page<Employee> findByNameContaining(String name, Pageable pageable) {
        return iEmployeeRepository.findByNameContaining(name,pageable);
    }

}

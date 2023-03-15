package com.example.furama.service;

import com.example.furama.model.Division;
import com.example.furama.model.EducationDegree;
import com.example.furama.model.Employee;
import com.example.furama.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(int id);
    List<Division> findAllDivision();
    List<EducationDegree> findAllEducation();
    List<Position> findAllPosition();
    Page<Employee> findAll(Pageable pageable, String name);
    Page<Employee> findByNameContaining(String name, Pageable pageable);
}

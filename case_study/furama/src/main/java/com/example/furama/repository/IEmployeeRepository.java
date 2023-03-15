package com.example.furama.repository;


import com.example.furama.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findByNameContaining(String name, Pageable pageable);
    @Query(value = " select * from `employee` where `name` like :name ", nativeQuery = true)
    Page<Employee> findAllName(Pageable pageable, @Param("name") String name);
}

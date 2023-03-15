package com.example.furama.repository;

import com.example.furama.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<EducationDegree,Integer> {
}

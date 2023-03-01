package com.example.furama.repository;

import com.example.furama.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractReposiroty extends JpaRepository<Contract,Integer> {
}

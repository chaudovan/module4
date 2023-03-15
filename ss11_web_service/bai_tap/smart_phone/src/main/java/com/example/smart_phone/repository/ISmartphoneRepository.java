package com.example.smart_phone.repository;

import com.example.smart_phone.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}

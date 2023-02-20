package com.example.demo3.repository;

import com.example.demo3.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatagoryRepository extends JpaRepository<Category,Integer> {
    Page<Category> findByNameContaining(String name, Pageable pageable);
}

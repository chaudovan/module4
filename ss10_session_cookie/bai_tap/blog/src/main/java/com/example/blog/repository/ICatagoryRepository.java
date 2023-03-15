package com.example.blog.repository;

import com.example.blog.model.Category;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatagoryRepository extends JpaRepository<Category,Integer> {
    Page<Category> findByNameContaining(String name, Pageable pageable);
}

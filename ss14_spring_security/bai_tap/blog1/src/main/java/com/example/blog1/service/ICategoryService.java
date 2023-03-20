package com.example.blog1.service;


import com.example.blog1.model.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Page<Category> searchName(String name, Pageable pageable);
    Category findById(int id);
    void update(Category category);
    void save(Category category);
    void deleteById(int id);
}

package com.example.blog.service.category;


import com.example.blog.model.Category;
import com.example.blog.model.Category;
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

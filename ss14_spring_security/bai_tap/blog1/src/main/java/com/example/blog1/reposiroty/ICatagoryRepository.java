package com.example.blog1.reposiroty;

import com.example.blog1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatagoryRepository extends JpaRepository<Category,Integer> {
    Page<Category> findByNameCContaining(String name, Pageable pageable);
}

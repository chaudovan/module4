package com.example.demo3.repository;

import com.example.demo3.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByNameContainingAndCategory_Id(String name,Integer id, Pageable pageable);
    Page<Blog> findByCategory_Id(Integer id, Pageable pageable);
    Page<Blog> findByNameContaining(String name,Pageable pageable);
}

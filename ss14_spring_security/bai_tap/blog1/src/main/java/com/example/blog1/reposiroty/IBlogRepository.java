package com.example.blog1.reposiroty;

import com.example.blog1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByNameContainingAndCategory_IdC(String name,Integer id, Pageable pageable);
    Page<Blog> findByCategory_IdC(Integer id, Pageable pageable);
    Page<Blog> findByNameContaining(String name,Pageable pageable);
}

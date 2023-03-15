package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByNameContainingAndCategory_Id(String name,Integer id, Pageable pageable);
//    Page<Blog> findByCategory_Id(Integer id, Pageable pageable);
    Page<Blog> findByNameContaining(String name,Pageable pageable);
    List<Blog> findByCategory_Id(Integer id);
    List<Blog> findByNameContaining(String name);
    @Query(value = " select * from `blog` where `name` like :name ", nativeQuery = true)
    List<Blog> findAllName(@Param("name") String name);
}

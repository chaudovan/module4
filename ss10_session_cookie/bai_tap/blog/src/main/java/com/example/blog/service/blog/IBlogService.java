package com.example.blog.service.blog;

import com.example.blog.model.Blog;
import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findByNameContainingAndCategory_Id(String name,Integer id, Pageable  pageable);
//    Page<Blog> findByCategory_Id(Integer id, Pageable pageable);
    Page<Blog> findByNameContaining(String name,Pageable pageable);
    Blog findById(int id);
    void update(Blog blog);
    void save(Blog blog);
    void deleteById(int id);
    List<Blog> findByCategory_Id(Integer id);
    List<Blog> search(String name);
    List<Blog> findAllName(String name);
}

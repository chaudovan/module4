package com.example.demo3.service.blog;

import com.example.demo3.model.Blog;
import com.example.demo3.model.Category;
import com.example.demo3.repository.IBlogRepository;
import com.example.demo3.repository.ICatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.StringContent;
import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository iBlogRepository;
    @Autowired
    ICatagoryRepository iCatagoryRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> findByNameContainingAndCategory_Id(String name,Integer id, Pageable pageable) {
        return iBlogRepository.findByNameContainingAndCategory_Id(name,id,pageable);
    }

    @Override
    public Page<Blog> findByCategory_Id(Integer id, Pageable pageable) {
        return iBlogRepository.findByCategory_Id(id,pageable);
    }

    @Override
    public Page<Blog> findByNameContaining(String name, Pageable pageable) {
        return iBlogRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteById(int id) {
        iBlogRepository.deleteById(id);
    }



}

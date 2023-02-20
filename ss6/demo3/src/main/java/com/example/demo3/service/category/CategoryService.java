package com.example.demo3.service.category;

import com.example.demo3.model.Category;
import com.example.demo3.repository.ICatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICatagoryRepository iCatagoryRepository;
    @Override
    public List<Category> findAll() {
        return iCatagoryRepository.findAll();
    }

    @Override
    public Page<Category> searchName(String name, Pageable pageable) {
        return iCatagoryRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Category findById(int id) {
        return iCatagoryRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Category category) {
        iCatagoryRepository.save(category);
    }

    @Override
    public void save(Category category) {
        iCatagoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
        iCatagoryRepository.deleteById(id);
    }
}

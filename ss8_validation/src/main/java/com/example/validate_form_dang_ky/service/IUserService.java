package com.example.validate_form_dang_ky.service;

import com.example.validate_form_dang_ky.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
    void delete(int id);
    User findById(int id);
    Page<User> findUserByFirstName(String firstName, Pageable pageable);
}

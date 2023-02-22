package com.example.validate_form_dang_ky.repository;

import com.example.validate_form_dang_ky.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    Page<User> findUserByFirstNameContaining(String firstName, Pageable pageable);
}

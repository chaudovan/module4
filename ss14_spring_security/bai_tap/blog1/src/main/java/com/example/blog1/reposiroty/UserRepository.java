package com.example.blog1.reposiroty;

import com.example.blog1.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String name);
}

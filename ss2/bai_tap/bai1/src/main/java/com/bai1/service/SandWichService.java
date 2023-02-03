package com.bai1.service;

import com.bai1.reposiroty.ISanWichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandWichService implements ISandWichService{
    @Autowired
    ISanWichRepository sanWichRepository;
    @Override
    public String save(String[] sandWich) {
        return sanWichRepository.save(sandWich);
    }
}

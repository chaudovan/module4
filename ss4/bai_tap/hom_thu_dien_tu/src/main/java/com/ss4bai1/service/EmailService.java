package com.ss4bai1.service;

import com.ss4bai1.model.HopThuEmail;
import com.ss4bai1.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailService implements IEmailService{
    @Autowired
    IEmailRepository emailRepository;
    @Override
    public List<HopThuEmail> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void save(HopThuEmail email) {
        emailRepository.save(email);
    }

    @Override
    public HopThuEmail findById(Integer id) {
        return emailRepository.findById(id);
    }

    @Override
    public void edit(Integer id, HopThuEmail hopThuEmail) {
        emailRepository.edit(id,hopThuEmail);
    }
}

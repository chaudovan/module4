package com.ss4bai1.repository;

import com.ss4bai1.model.HopThuEmail;

import java.util.List;

public interface IEmailRepository {
    List<HopThuEmail> findAll();
    void save(HopThuEmail email);
    HopThuEmail findById(Integer id);
    void edit(Integer id,HopThuEmail hopThuEmail);
}

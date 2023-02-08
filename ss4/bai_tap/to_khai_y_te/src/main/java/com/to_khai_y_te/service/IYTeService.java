package com.to_khai_y_te.service;

import com.to_khai_y_te.model.ToKhaiYTe;

import java.util.List;

public interface IYTeService {
    List<ToKhaiYTe> findAll();
    void editYTe(int id,ToKhaiYTe toKhaiYTe);
    ToKhaiYTe findById(int id);
}

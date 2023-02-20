package com.to_khai_y_te.repository;

import com.to_khai_y_te.model.ToKhaiYTe;

import java.util.List;

public interface IYTeRepository {
    List<ToKhaiYTe> findAll();

    void editYTe(int id, ToKhaiYTe toKhaiYTe);

    ToKhaiYTe findById(int id);
}

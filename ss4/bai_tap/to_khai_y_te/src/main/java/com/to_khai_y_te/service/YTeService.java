package com.to_khai_y_te.service;

import com.to_khai_y_te.model.ToKhaiYTe;
import com.to_khai_y_te.repository.IYTeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YTeService implements IYTeService {
    @Autowired
    IYTeRepository iyTeRepository;

    @Override
    public List<ToKhaiYTe> findAll() {
        return iyTeRepository.findAll();
    }


    @Override
    public void editYTe(int id, ToKhaiYTe toKhaiYTe) {
        iyTeRepository.editYTe(id, toKhaiYTe);
    }

    @Override
    public ToKhaiYTe findById(int id) {
        return iyTeRepository.findById(id);
    }
}

package com.baitap2.service;

import com.baitap2.repository.ITuDienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuDien implements ITuDien {
    @Autowired
    ITuDienRepository tuDienRepository;

    @Override
    public String traTu(String keyWord) {
        String result = tuDienRepository.traTu(keyWord);
        if (result == null) {
            return result = "not exits";
        }
        return result;
    }
}

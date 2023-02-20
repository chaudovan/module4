package com.bai2.service;

import com.bai2.repository.ICaculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Autowired
    ICaculatorRepository iCaculatorRepository;

    @Override
    public Double caculator(Double num1, Double num2, String operator) {
        return iCaculatorRepository.caculator(num1, num2, operator);
    }
}

package com.bai2.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CaculatorRepository implements ICaculatorRepository{
    @Override
    public Double caculator(Double num1, Double num2, String operator) {
        switch (operator){
            case "ADDITION":
                return num1+num2;
            case "SUBTRACTION":
                return num1-num2;
            case "MUTIPLICATION":
                return num1*num2;
            case "DIVISION":
                return num1/num2;
            default:
                return 0.0;
        }
    }
}

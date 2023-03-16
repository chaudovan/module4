package com.example.furama.dto;

import com.example.furama.model.Division;
import com.example.furama.model.EducationDegree;
import com.example.furama.model.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmployeeDto implements Validator {
    private int id;
    @NotEmpty
    private String name;
    private String dateOfBirth;
    private String idCard;
    private double salary;
    private String phone;
    @Email
    private String email;
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

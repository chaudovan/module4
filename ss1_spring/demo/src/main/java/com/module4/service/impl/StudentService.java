package com.module4.service.impl;

import com.module4.model.Student;
import com.module4.repository.IRepositoryStudent;
import com.module4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IRepositoryStudent iRepositoryStudent;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = iRepositoryStudent.findAll();
        return studentList;
    }
}

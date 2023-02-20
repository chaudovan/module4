package com.module4.repository.impl;

import com.module4.model.Student;
import com.module4.repository.IRepositoryStudent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IRepositoryStudent {
    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "chau", "chau@gmail.com"));
        studentList.add(new Student(2, "huy", "huy@gmail.com"));
        studentList.add(new Student(3, "dong", "dong@gmail.com"));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }
}

package com.module4.controller;

import com.module4.model.Student;
import com.module4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @GetMapping("/student")
    public String show(Model model) {
        List<Student> studentList = iStudentService.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }
}

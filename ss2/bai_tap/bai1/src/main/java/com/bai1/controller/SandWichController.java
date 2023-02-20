package com.bai1.controller;

import com.bai1.service.ISandWichService;
import com.bai1.service.SandWichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandWichController {
    @Autowired
    ISandWichService sandWichService;

    @GetMapping("/save")
    public String show() {
        return "sandwich";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "sandWich", defaultValue = "Please choice") String[] sandWich, Model model) {
        String result = sandWichService.save(sandWich);
        model.addAttribute("result", result);
        return "sandwich";
    }
}

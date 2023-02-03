package com.bai2.controller;

import com.bai2.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    ICaculatorService caculatorService;
    @GetMapping("/caculator")
    public String show(){
        return "caculator";
    }
    @PostMapping("/caculator")
    public String operator(@RequestParam double num1, double num2, String operator, Model model){
        double result = caculatorService.caculator(num1,num2,operator);
        model.addAttribute("result",result);
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        return "caculator";
    }
}

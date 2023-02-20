package com.module4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChuyenDoiTienTeController {
    @GetMapping("/tienTe")
    public String showForm() {
        return "showForm";
    }

    @PostMapping("/usd")
    public String tinh(@RequestParam String usd, String rate, Model model) {
        Double sum = Double.parseDouble(usd) * Double.parseDouble(rate);
        model.addAttribute("sum", sum);
        return "formTinh";
    }
}

package com.baitap2.controller;

import com.baitap2.service.ITuDien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TuDienConTroller {
    @Autowired
    ITuDien tuDien;
    @GetMapping("/tratu")
    public String showTraTu(){
        return "tratu";
    }
    @PostMapping("/tratu")
    public String show(@RequestParam String keyWord, Model model){
        String result = tuDien.traTu(keyWord);
        model.addAttribute("keyWord",result);
        return "tratu";
    }
}

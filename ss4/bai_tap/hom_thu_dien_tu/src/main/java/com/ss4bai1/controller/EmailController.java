package com.ss4bai1.controller;

import com.ss4bai1.model.HopThuEmail;
import com.ss4bai1.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    IEmailService emailService;
    @ModelAttribute("languages")
    public String[] showLanguage(){
        return  new String[]{"English","Vietnamese","Japanese","Chinese"};
    }
    @ModelAttribute("size")
    public int[] showSize(){
        return  new int[]{5, 10, 15, 25, 50, 100};
    }
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("emailList",emailService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("email",new HopThuEmail());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute HopThuEmail email){
        emailService.save(email);
        return "redirect:/email";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model){
        HopThuEmail hopThuEmail = emailService.findById(id);
        model.addAttribute("emailEdit",hopThuEmail);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute HopThuEmail emailEdit){
        emailService.edit(emailEdit.getId(),emailEdit);
        return "redirect:/email";
    }
}

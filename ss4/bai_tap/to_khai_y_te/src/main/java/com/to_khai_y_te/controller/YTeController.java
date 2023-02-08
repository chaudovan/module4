package com.to_khai_y_te.controller;

import com.to_khai_y_te.model.ToKhaiYTe;
import com.to_khai_y_te.service.IYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/yte")
public class YTeController {
    @Autowired
    IYTeService iyTeService;
    @ModelAttribute("dayInput")
    public String[] inputDay(){
        return new String[]{"01","02","03","04","05","06","07","..","28","29","30"};
    }
    @ModelAttribute("monthInput")
    public String[] inputMonth(){
        return new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
    }
    @ModelAttribute("yearInput")
    public String[] inputYear(){
            return new String[]{"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"};
    }
    @ModelAttribute("vehicle")
    public String[] input(){
        return new String[]{"Oto","Moto","Máy bay","Tàu Thuyền","khác"};
    }
    @ModelAttribute("national")
    public String[] inputNationel(){
        return new String[]{"Việt Nam","Mỹ","Trung Quốc"};
    }
    @ModelAttribute("gender")
    public String[] inputGender(){
        return new String[]{"Nam","Nữ","LGBT"};
    }
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("yTeList",iyTeService.findAll());
        return "list";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model){
        ToKhaiYTe yTeEdit = iyTeService.findById(id);
        model.addAttribute("edit",yTeEdit);
        return "edit";
    }
    @PostMapping("/edit")
    public String editYTe(@ModelAttribute ToKhaiYTe edit){
        iyTeService.editYTe(edit.getId(),edit);
        return "redirect:/yte";
    }
}

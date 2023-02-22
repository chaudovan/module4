package com.example.validate_form_dang_ky.controller;

import com.example.validate_form_dang_ky.dto.UserDto;
import com.example.validate_form_dang_ky.model.User;
import com.example.validate_form_dang_ky.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("")
    public String showList(Model model,@RequestParam(defaultValue = "0") int page){
        String name = "";
        Pageable pageable = PageRequest.of(page,2, Sort.by("firstName").descending());
        model.addAttribute("listUser",iUserService.findUserByFirstName(name,pageable));
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create";
    }
    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        User user= new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/delete")
    public String deleteUser(@RequestParam int id){
        iUserService.delete(id);
        return "redirect:/users";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id,Model model){
        model.addAttribute("userDto",iUserService.findById(id));
        return "edit";
    }
    @PostMapping("edit")
    public String editUser(@Validated @ModelAttribute UserDto userDto,BindingResult bindingResult){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "edit";
        }
        User user= new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.save(user);
        return "redirect:/users";
    }
}

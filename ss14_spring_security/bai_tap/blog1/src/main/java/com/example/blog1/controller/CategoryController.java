package com.example.blog1.controller;

import com.example.blog1.model.Category;
import com.example.blog1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "0") int page){

        Pageable pageable = PageRequest.of(page,2);

        Page<Category> pages = iCategoryService.searchName(searchName,pageable);
        model.addAttribute("pages",pages);
        model.addAttribute("searchName",searchName);
        return "category/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }
    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category){
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id,Model model){
        Category category = iCategoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit";
    }
    @PostMapping("edit")
    public String editBlog(@ModelAttribute Category category){
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("delete")
    public String deleteBlog(@RequestParam int id){
        iCategoryService.deleteById(id);
        return "redirect:/category";
    }
}

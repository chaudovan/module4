package com.baitapss3.controller;

import com.baitapss3.model.Product;
import com.baitapss3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @ModelAttribute("size")
    public int size(){
        int size = iProductService.findAll().size();
        return size;
    }
    @ModelAttribute("types")
    public String[] inputType(){
        return new String[]{"Sách Tay","Nội Địa","Loại Thứ 3"};
    }
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("productList",iProductService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("create")
    public String createNew(@ModelAttribute Product product){
        iProductService.createProduct(product);
        return "redirect:/product";
    }
    @GetMapping("/detail")
    public String showDetail(@RequestParam int id, Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "detail";
    }
    @GetMapping("/search")
    public String searchProduct(@RequestParam String search, Model model){
        model.addAttribute("productList",iProductService.searchProduct(search));
        return "list";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Product product){
        iProductService.editProduct(product.getIdProduct(),product);
        return "redirect:/product";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id){
        iProductService.deleteProduct(id);
        return "redirect:/product";
    }
}

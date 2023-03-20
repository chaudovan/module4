package com.example.blog1.controller;



import com.example.blog1.model.Blog;
import com.example.blog1.service.IBlogService;
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
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(required = false, defaultValue = "0") int id,
                           @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> pages = null ;
        if(searchName.equals("") && id==0){
            pages = iBlogService.findByNameContaining(searchName,pageable);
        }else if(searchName.equals("")){
            pages = iBlogService.findByCategory_Id(id,pageable);
        }else {
            pages = iBlogService.findByNameContainingAndCategory_Id(searchName,id,pageable);
        }
//        Pageable pageable = PageRequest.of(page,2, Sort.by("time").descending());
        model.addAttribute("categorySearch",iCategoryService.findById(id));
        model.addAttribute("pages",pages);
        model.addAttribute("searchName",searchName);
        model.addAttribute("id",id);
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/create";
    }
    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "blog/edit";
    }
    @PostMapping("edit")
    public String editBlog(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("delete")
    public String deleteBlog(@RequestParam int id){
        iBlogService.deleteById(id);
        return "redirect:/blog";
    }
}

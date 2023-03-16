package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.blog.IBlogService;
import com.example.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;
    private int dem=2;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogList = iBlogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Blog blog){
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping("/edit")
    public ResponseEntity<?> editBlog(@RequestBody Blog blog){
        Blog blog1 = iBlogService.findById(blog.getId());
        if(blog1==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable int id){
        Blog blog = iBlogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categoryList = iCategoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }
    @GetMapping("/idCategory/{id}")
    public ResponseEntity<List<Blog>> getBlogCategory(@PathVariable int id){
        List<Blog> blogList = iBlogService.findByCategory_Id(id);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> searchBlog(@PathVariable String name){
        List<Blog> blogList = iBlogService.search(name);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/quantity")
    public ResponseEntity<List<Blog>> showLimit(){
        dem +=2;
        List<Blog> blogList = iBlogService.getBlogList(dem);
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}

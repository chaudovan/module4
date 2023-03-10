package com.example.product.controller;

import com.example.product.dto.CartDto;
import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto cart(){
        return new CartDto();
    }
    @GetMapping("")
    public String showList(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") int idProduct) {
        model.addAttribute("historyProduct", iProductService.findById(idProduct));
        model.addAttribute("productList", iProductService.findAll());
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable int id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct",id + "");
        cookie.setMaxAge(1*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("view", "product", iProductService.findById(id));
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCard(@PathVariable int id,
                            @ModelAttribute("cart") CartDto cart) {
        Product productDetail = iProductService.findById(id);
        if (productDetail!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail, productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}

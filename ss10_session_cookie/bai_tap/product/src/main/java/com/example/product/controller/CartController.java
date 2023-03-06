package com.example.product.controller;

import com.example.product.dto.CartDto;
import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.service.IProductService;
import com.example.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(name = "cart",required = false) CartDto cartDto){
        ModelAndView modelAndView = new ModelAndView("cart","cart",cartDto);
        return modelAndView;
    }
    @GetMapping("delete")
    public String delete(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.removeProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("decrement")
    public String decrement(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.decrementProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("increase")
    public String increase(@RequestParam int id, @SessionAttribute(name = "cart", required = false) CartDto cart) {
        Product product = productService.findById(id);
        if (product!=null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cart.increaseProduct(productDto);
        }
        return "redirect:/cart";
    }
}

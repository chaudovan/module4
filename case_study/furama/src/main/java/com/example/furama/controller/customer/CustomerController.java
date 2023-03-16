package com.example.furama.controller.customer;

import com.example.furama.dto.CustomerDto;
import com.example.furama.model.Customer;
import com.example.furama.model.Employee;
import com.example.furama.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Customer> pages = null ;
        pages = customerService.findAllName(pageable,searchName);
        model.addAttribute("pages",pages);
        model.addAttribute("searchName",searchName);
        return "customer/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        model.addAttribute("customerTypes",customerService.findAllCusType());
        return "customer/create";
    }
    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult,Model model){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypes",customerService.findAllCusType());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        model.addAttribute("customerTypes",customerService.findAllCusType());
        return "customer/edit";
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/delete")
    public String deleteCus(@RequestParam int id){
        customerService.deleteById(id);
        return "redirect:/customer";
    }
}

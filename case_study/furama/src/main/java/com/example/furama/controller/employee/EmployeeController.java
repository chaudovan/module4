package com.example.furama.controller.employee;

import com.example.furama.model.Employee;
import com.example.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Employee> pages = null ;
//        pages = iEmployeeService.findByNameContaining(searchName,pageable);
        pages = iEmployeeService.findAll(pageable,searchName);
        model.addAttribute("pages",pages);
        model.addAttribute("searchName",searchName);
        model.addAttribute("divisionList",iEmployeeService.findAllDivision());
        model.addAttribute("educationList",iEmployeeService.findAllEducation());
        model.addAttribute("positionList",iEmployeeService.findAllPosition());
        model.addAttribute("employeeDto",new Employee());
        model.addAttribute("employeeCreate",new Employee());
        return "employee/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("divisionList",iEmployeeService.findAllDivision());
        model.addAttribute("educationList",iEmployeeService.findAllEducation());
        model.addAttribute("positionList",iEmployeeService.findAllPosition());
        return "employee/create";
    }
    @PostMapping("/create")
    public String createEmployee(@ModelAttribute Employee employee){
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model,@RequestParam(required = false, defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,2);
        Page<Employee> pages = null ;
        pages = iEmployeeService.findByNameContaining(searchName,pageable);
        model.addAttribute("pages",pages);
        model.addAttribute("divisionList",iEmployeeService.findAllDivision());
        model.addAttribute("educationList",iEmployeeService.findAllEducation());
        model.addAttribute("positionList",iEmployeeService.findAllPosition());
        Employee employee = iEmployeeService.findById(id);
        model.addAttribute("employeeDto",employee);
        model.addAttribute("employeeCreate",new Employee());
        model.addAttribute("check",1);
        return "employee/list";
    }
    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute Employee employeeDto){
        iEmployeeService.update(employeeDto);
        return "redirect:/employee";
    }
}

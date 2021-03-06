package edu.mum.cs.ormexample.controller;

import edu.mum.cs.ormexample.model.Employee;
import edu.mum.cs.ormexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String add(@ModelAttribute Employee emp){
        return "employeeForm";
    }

    @PostMapping("/")
    public String save(Employee e){
        employeeRepository.save(e);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success(Model model){
        model.addAttribute("emps",  employeeRepository.findAll());
        return "employeeList";
    }

    @GetMapping("/display")
    public String display(@RequestParam(required = false, defaultValue = "") String zipCode, Model model){
        if(!"".equals(zipCode)){
            model.addAttribute("emps", employeeRepository.someName(zipCode));
        }else{
            model.addAttribute("emps",  employeeRepository.findAll());
        }
        return "employeeList";
    }
}

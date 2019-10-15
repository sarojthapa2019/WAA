package edu.mum.cs.waa.lab.ormrelationship_lab10.controller;

import edu.mum.cs.waa.lab.ormrelationship_lab10.domain.Address;
import edu.mum.cs.waa.lab.ormrelationship_lab10.domain.Employee;
import edu.mum.cs.waa.lab.ormrelationship_lab10.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String home(@ModelAttribute Employee employee) {
        return "employeeAddForm";
    }

    @PostMapping("/add")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult
            , Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "employeeAddForm";
        }
        Address address = employee.getAddress();
        address.setEmployee(employee);
        employeeService.saveEmployee(employee);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employeeEditForm";
        }
        return "employeeList";
    }

    @PostMapping("/edit")
    public String updateEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "employeeEditForm";
        }
        employee.getAddress().setEmployee(employee);
        employeeService.saveEmployee(employee);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee != null){
            employeeService.deleteEmployee(employee);
        }
        return "redirect:/list";
    }
    @GetMapping("/list")
    public String getAllEmployees(Model model){
        model.addAttribute("empList", employeeService.getAll());
        return "list";
    }
    @GetMapping("/list/number")
    public String getEmployeeByNumber(@RequestParam String number, Model model){
        Optional<Employee> e = employeeService.getEmployeeByNumber(number);
        if( e.isPresent()) {
            model.addAttribute("empList", employeeService.getEmployeeByNumber(number).get());
            return "list";
        }

            model.addAttribute("empty", "No Data found!!");
            return "list";

    }
}

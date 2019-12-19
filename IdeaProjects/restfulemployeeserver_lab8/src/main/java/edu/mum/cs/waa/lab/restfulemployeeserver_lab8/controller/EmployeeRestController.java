package edu.mum.cs.waa.lab.restfulemployeeserver_lab8.controller;

import edu.mum.cs.waa.lab.restfulemployeeserver_lab8.domain.Employee;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EmployeeRestController {
    @CrossOrigin(value = {"http://localhost:9999"}, maxAge = 5000)
    @PostMapping(value = "/employee")
    public @ResponseBody Employee addEmployee(@Valid @RequestBody Employee employee){
        return employee;
    }

}

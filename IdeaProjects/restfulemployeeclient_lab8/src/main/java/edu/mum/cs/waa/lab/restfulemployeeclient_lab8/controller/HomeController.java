package edu.mum.cs.waa.lab.restfulemployeeclient_lab8.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @GetMapping(value="/")
    public String welcome(){
        return "addEmployee";
    }
}

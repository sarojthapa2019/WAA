package edu.mum.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;

@Controller
public class HomeController {

    @Autowired
    ServletContext servletContext;

    @GetMapping(value = {"/", "/index"})
    public String getIndex(){
        System.out.println("Application Init Parameter: " + servletContext.getInitParameter("spring.profiles.default"));
        System.out.println("Application Attribute: " + servletContext.getAttribute("appName"));
        return "index";
    }
}

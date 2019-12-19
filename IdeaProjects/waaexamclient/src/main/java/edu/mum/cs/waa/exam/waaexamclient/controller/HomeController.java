package edu.mum.cs.waa.exam.waaexamclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "book";
    }
    @GetMapping("/book/detail/{id}")
    public String bookDetail(@PathVariable Integer id, Model model){
        model.addAttribute("bookId", id);
        return "bookDetail";
    }
}

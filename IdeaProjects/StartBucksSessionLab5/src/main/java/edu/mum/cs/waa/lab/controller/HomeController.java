package edu.mum.cs.waa.lab.controller;

import edu.mum.cs.waa.lab.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

@Controller
@SessionAttributes("user")
public class HomeController {
    @GetMapping("/")
    public String welcome(Map map){
        User user = (User) map.get("user");
        if(user != null){
            return "redirect:/advice";
        }
        return "welcome";
    }
}

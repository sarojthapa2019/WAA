package edu.mum.cs.ormrelationships.manytomany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		return "redirect:/user/addUser";
	}

}

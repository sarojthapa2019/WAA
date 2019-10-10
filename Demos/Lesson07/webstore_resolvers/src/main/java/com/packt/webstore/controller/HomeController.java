package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping
	public String welcome(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		
		redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!!!!!");
		redirectAttributes.addFlashAttribute("The one and only amazing web store!!!!!");
//		return "redirect:/welcome/greeting";
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting(@RequestParam(required=false) String greeting, @RequestParam(required=false) String tagline) {
		System.out.println("greeting: " + greeting);
		System.out.println("tagline: " + tagline);
		return "welcome";
	}

}

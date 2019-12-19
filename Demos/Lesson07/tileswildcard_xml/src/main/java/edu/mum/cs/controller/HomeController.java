package edu.mum.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "user/home";
	}

	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String productsPage(ModelMap model) {
		return "user/admin";
	}

	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "user/manager";
	}
}
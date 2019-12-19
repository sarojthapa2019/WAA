package edu.mum.cs.ormrelationships.manytomany.controller;

import java.util.List;

import edu.mum.cs.ormrelationships.manytomany.domain.Role;
import edu.mum.cs.ormrelationships.manytomany.domain.User;
import edu.mum.cs.ormrelationships.manytomany.service.RoleService;
import edu.mum.cs.ormrelationships.manytomany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public String getAddUserForm(@ModelAttribute("user") User user, Model model) {
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "manytomany/UserForm";
	}
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String processAddUserForm(@ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		User savedUser = userService.save(user);
		redirectAttributes.addFlashAttribute("user", savedUser);
		return "redirect:/user/detail";
	}
	
	@RequestMapping("/detail")
	public String detail() {
		return "manytomany/detail";
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handle(Exception e) {
	    System.out.println("Returning HTTP 400 Bad Request"+e);
	}

}

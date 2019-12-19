package edu.mum.cs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({ "Leonardo", "Splinter" })
public class DemoController {
	
	@Autowired
	DisplaySessionHelper displaySession;
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String delegate(Model model, ModelMap m, HttpSession session, SessionStatus status) {

		System.out.println("DELEGATE SESSION GET");
		System.out.println();

		// Display Session attribute[s]
		displaySession.getSessionAttributes(model.asMap(), session);
	

		return "DelegateDetails";
	}
}

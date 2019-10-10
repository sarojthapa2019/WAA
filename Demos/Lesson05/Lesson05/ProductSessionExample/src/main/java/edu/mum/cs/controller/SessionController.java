package edu.mum.cs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.cs.domain.Product;

@Controller
@SessionAttributes({ "Leonardo", "Splinter" })
public class SessionController {

	@Autowired
	DisplaySessionHelper displaySession;
	

	@RequestMapping(value = { "/getSession" }, method = RequestMethod.GET)
	public String inputProduct(Model model, HttpSession session) {

		System.out.println("SESSION GET");
		System.out.println();

		// Display Session attribute[s]
		displaySession.getSessionAttributes(model.asMap(), session);

		// Add @SessionAttributes
		addSessionAttributes(model);

		// add Regular attribute
		session.setAttribute("Donatello", "Donatello Turtle");

		return "SessionForm";
	}

	@RequestMapping(value = "/postSession", method = RequestMethod.POST)
	public String saveProduct(Model model, SessionStatus status,
			HttpServletRequest request) {

		System.out.println("SESSION POST");
		System.out.println();
		
		//quick demo purpose
//		Product product = (Product) model.asMap().get("Leonardo");
//		System.out.println(product);
		
		// Display Session attribute[s]
		displaySession.getSessionAttributes(model.asMap(), request.getSession());

		// Remove @SessionAttributes AFTER return from method
		status.setComplete();

		return "SessionDetails";

	}

	public void addSessionAttributes(Model model) {
		Product product = new Product();
		product.setName("Leonardo Turtle");
		model.addAttribute("Leonardo", product);
		model.addAttribute("Splinter", "Splinter");
	}

}

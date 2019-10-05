package edu.mum.cs.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs.domain.Product;

@Controller
public class ProductController {

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String inputProduct(Model model, HttpSession session, HttpServletRequest request) {

		System.out.println("PRODUCT GET");
		
		System.out.printf("Context Param Value : %s\n", request.getServletContext().getInitParameter("contextparamname"));
		System.out.printf("HttpServletRequest Application Name : %s\n", request.getServletContext().getAttribute("appName"));
		// Application level attribute set in XML servlet configuration
		System.out.printf("Application Name : %s\n", servletContext.getAttribute("appName"));

		return "ProductForm";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveProduct(Product newProduct, Model model, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {

		System.out.println("PRODUCT POST");

		// Application level attribute set in XML servlet configuration
		System.out.printf("Application Name : %s\n", servletContext.getAttribute("appName"));

		// this is the NO PRG pattern return..
		if (!newProduct.isPrgFlag())
			return "ProductDetails";

		// THIS IS PRG PATTERN
		// Available as request attribute [named "product"] in the GET method
		redirectAttributes.addFlashAttribute(newProduct);
		// Returned as a parameter on GET URL
		redirectAttributes.addAttribute("name", "Kemosabe");
		redirectAttributes.addFlashAttribute(123456);
		redirectAttributes.addAttribute(newProduct.getName());
		

		return "redirect:/details";

	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String productDetails(Model model) {
		System.out.println("PRODUCT POST-REDIRECT");

		// PRG flash Attribute "product" & "name" is in the Model and
		// is displayed on ProductDetailspage
		return "ProductDetails";
	}

}

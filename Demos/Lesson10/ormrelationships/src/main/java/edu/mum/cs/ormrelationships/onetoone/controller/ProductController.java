package edu.mum.cs.ormrelationships.onetoone.controller;

import java.util.List;

import edu.mum.cs.ormrelationships.onetoone.domain.Product;
import edu.mum.cs.ormrelationships.onetoone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String inputProduct(@ModelAttribute("product") Product product) {
		return "onetoone/ProductForm";
	}

	@PostMapping("/")
	public String saveProduct(Product product) {

		// ....Demo Cascade
		// Best practice on bidirectional set BOTH ends ["Pretend" no DB]
		product.getHotLine().setProduct(product);
		product = productService.save(product); // insert & [ insert OR Update of phone]

		return "onetoone/ProductDetails";
	}
	
	@GetMapping("/listproducts")
	public String listProducts(Product product, Model model) {

		List<Product> list = productService.getAllProducts();
		list.forEach(System.out::println);
		model.addAttribute("products", list);

		return "onetoone/ListProducts";
	}
	
}

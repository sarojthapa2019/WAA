package com.packt.webstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/market")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, Model model) {
		return "addProduct";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processAddNewProductForm(@Valid @ModelAttribute("newProduct") Product newProduct,
			BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addProduct";
		}

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				System.out.println(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png");
				productImage.transferTo(
						new File(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}

		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}

	@RequestMapping("/product")
	public String getProductDetail(@RequestParam(value = "id", required = false) String productId, Model model) {
		model.addAttribute(productService.getProductById(productId));
		return "product";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
//		binder.setValidator(unitsInStockValidator);
//		binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category",
//				"unitsInStock", "condition", "productImage", "userManual", "language");
//		binder.setDisallowedFields("productImage", "userManual");

	}

	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable String category) {
		List<Product> products = productService.getProductsByCategory(category);
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException("No Products Found Under Category.");
		}
		model.addAttribute("products", products);
		return "products";
	}

	@ExceptionHandler(NoProductsFoundUnderCategoryException.class)
	public ModelAndView handleError(HttpServletRequest req, NoProductsFoundUnderCategoryException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", exception.getMessage());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("noProductFound");
		return mav;
	}

//	@ExceptionHandler(NoProductsFoundUnderCategoryException.class)
//	public String handleError(HttpServletRequest req, NoProductsFoundUnderCategoryException exception, Model model) {
//		model.addAttribute("msg", exception.getMessage());
//		model.addAttribute("exception", exception);
//		model.addAttribute("url", req.getRequestURL());
//		return "noProductFound";
//	}

}

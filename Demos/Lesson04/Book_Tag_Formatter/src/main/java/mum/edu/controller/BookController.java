package mum.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mum.edu.domain.Book;
import mum.edu.domain.Category;
import mum.edu.domain.ISBNumber;
import mum.edu.service.BookService;
import mum.edu.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private CategoryService categoryService;

	// Used by all Controller handler methods
	// book list is added to model as "books"...
	@ModelAttribute("books")
	List<Book> addBookList(Model model) {
		System.out.println("===========addBookList=============");
		return bookService.getAllBooks();
	}

	@RequestMapping(value = { "/", "/book_list" })
	public String listBooks() {
		// List is added to model by @ModelAttribute on addBookList method
		
		return "BookList";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String inputBook(@ModelAttribute("newBook") Book book, Model model) {

		// Domain Object for search FORM - can also put it in Signature...
		// public String inputBook(@ModelAttribute("newBook") Book book,
		// @ModelAttribute("bookSearch") Book bookSearch,Model model) {
		model.addAttribute("bookSearch", new Book());

		// List is added to model by @ModelAttribute on addBookList method
		// displayed in BookAddForm

		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);

		//Uncomment to test form:select with Map.
		/* Map<Integer,String> country = new HashMap<Integer,String>();
		 country.put(1, "United Stated");
		 country.put(2, "China");
		 country.put(3, "Singapore");
		 country.put(4, "Malaysia");
		 model.addAttribute("countryList", country);*/

		return "BookAddForm";
	}

	// from BookAddForm
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("newBook") Book book, BindingResult result) {
		System.out.println(book);
		String[] suppressedFields = result.getSuppressedFields();

		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		// Category id from form
		Category category = categoryService.getOne(book.getCategory().getId());
		book.setCategory(category);

		bookService.save(book);

		return "redirect:/book_list";
	}

	// Book to edit From Drop down list on BookAddForm.jsp & BookEditForm.jsp
	@RequestMapping(value = "/editBook", method = RequestMethod.POST)
	public String editBook(@ModelAttribute("bookSearch") Book searchBook, Model model) {

		// Domain object for edit from @ModelAttribute "searchBook"
		System.out.println(searchBook);
		Book book = bookService.get(searchBook.getId());
		model.addAttribute("editBook", book);
		System.out.println(book);
		// Category list for form
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);

		// List is added to model by @ModelAttribute on addBookList method
		// displayed in BookEditForm

		return "BookEditForm";
	}

	// book to save from BookEditForm
	@RequestMapping(value = "/book_update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("editBook") Book book) {

		// Category id from form - get Category
		Category category = categoryService.getOne(book.getCategory().getId());
		book.setCategory(category);

		bookService.update(book);

		return "redirect:/book_list";
	}

	// Book to edit from bookList.jsp - gets id from @PathVariable
	@RequestMapping(value = "/book_edit/{id}", method = RequestMethod.GET)
	public String editBook(Model model, @PathVariable("id") long id) {

		// Domain Object for search
		model.addAttribute("bookSearch", new Book());

		// Domain Object for edit from @PathVariable
		// Auto populate the values in JSP
		Book book = bookService.get(id);
		model.addAttribute("editBook", book);

		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);

		return "BookEditForm";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
//		binder.setDisallowedFields("id");
		binder.setAllowedFields("isbn", "title", "category.id", "author", "publishDate");
	}


}

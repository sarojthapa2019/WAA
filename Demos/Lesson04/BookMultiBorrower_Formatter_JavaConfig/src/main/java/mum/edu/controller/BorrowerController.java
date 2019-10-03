package mum.edu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.domain.Book;
import mum.edu.domain.Borrower;
import mum.edu.service.BookService;
import mum.edu.service.BorrowerService;

@Controller
public class BorrowerController {

	private BorrowerService borrowerService;

	private BookService bookService;

	private ServletContext servletContext;

	public BorrowerController(BorrowerService borrowerService, BookService bookService, ServletContext servletContext) {
		this.borrowerService = borrowerService;
		this.bookService = bookService;
		this.servletContext = servletContext;
	}

	@RequestMapping(value = { "/", "/borrowerList" }, method = RequestMethod.GET)
	public String listBorrowers(Model model) {

		Map<Long, Borrower> borrowers = borrowerService.getAllBorrowers();
		model.addAttribute("borrowers", borrowers);
		String name = servletContext.getInitParameter("spring.profiles.default");
		System.out.println("==============" + name);
		
		return "BorrowerList";
	}

	@RequestMapping(value = "/borrowBooks", method = RequestMethod.GET)
	public String borrowBooks(@ModelAttribute("borrower") Borrower borrower, @RequestParam("borrower") long id,
			Model model) {

		Borrower borrowerData = borrowerService.get(id);
		model.addAttribute("borrower", borrowerData);
		// model.addAttribute("borrowerBooks", borrowerData.getBooks());

		Map<Long, Book> books = bookService.getAllBooks();
		List<Book> bookList = new ArrayList<Book>(books.values());
		model.addAttribute("books", bookList);

		return "BorrowBookForm";
	}

//	@RequestMapping(value = "/borrowBooks", method = RequestMethod.POST)
//	public String borrowBooks(@ModelAttribute("borrower") Borrower borrower, Model model) {
//		System.out.println(borrower);
//		model.addAttribute("borrower", borrower);
//
//		return "BorrowerDetails";
//	}

	@RequestMapping(value = "/borrowBooks", method = RequestMethod.POST)
	public String updateBorrower(@ModelAttribute("borrower") Borrower borrower, RedirectAttributes redirectAttributes) {
		// Books have been "fetched" in the formatter
		borrowerService.update(borrower);

		redirectAttributes.addFlashAttribute(borrower);

		return "redirect:/borrowerDetails";
	}

	@RequestMapping("/borrowerDetails")
	public String borrowerDetails(SessionStatus status) {
		return "BorrowerDetails";
	}
}

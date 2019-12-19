package edu.mum.cs.waa.exam.exampractice.controller;

import edu.mum.cs.waa.exam.exampractice.domain.Book;
import edu.mum.cs.waa.exam.exampractice.domain.Category;
import edu.mum.cs.waa.exam.exampractice.domain.Review;
import edu.mum.cs.waa.exam.exampractice.repository.ReviewRepository;
import edu.mum.cs.waa.exam.exampractice.service.BookService;
import edu.mum.cs.waa.exam.exampractice.service.CategoryService;
import edu.mum.cs.waa.exam.exampractice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

@Controller
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;
    private ReviewService reviewService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, ReviewService reviewService){
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.reviewService = reviewService;
    }
    @ModelAttribute("books")
    public Iterable<Book> getAllBooks(Model model){
        return bookService.getAllBooks();
    }
    @ModelAttribute("categories")
    public Iterable<Category> getAllCategories(Model model){
        return categoryService.getAllCategories();
    }

    @GetMapping("/book")
    public String book(@ModelAttribute("book") Book book, Model model){

        return "book";
    }
    @PostMapping("/book/add")
    public String addBook(@Valid @ModelAttribute Book book, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "book";
        }
        bookService.saveBook(book);
        return "redirect:/book";
    }
//    @GetMapping("/book/redirect")
//    public String redirectPage(){
//
//    }

    @GetMapping("/book/detail/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model){
        Optional<Book> book = bookService.findById(id);
        model.addAttribute("book", book.get());
        model.addAttribute("review", new Review());
        return "bookDetail";
    }
    @PostMapping("book/addreview/{id}")
    public String addReview(@Valid @ModelAttribute("review") Review review,
                            BindingResult bindingResult, @PathVariable Long id, Model model){
        if(bindingResult.hasErrors()){
            return "bookDetail";
        }
        Book book = bookService.findById(id).get();
        book.getReviewList().add(review);
        bookService.saveBook(book);

        return "redirect:/book/detail/"+id;
    }
    @GetMapping("/book/category")
    public String getBooksByCategory(@ModelAttribute Book book, @RequestParam Long iid, @RequestParam Long id,  Model model){
        model.addAttribute("books", bookService.findByCategoryId(id, iid));
        return "book";
    }
}

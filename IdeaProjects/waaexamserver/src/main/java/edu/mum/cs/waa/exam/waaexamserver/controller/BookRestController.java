package edu.mum.cs.waa.exam.waaexamserver.controller;

import edu.mum.cs.waa.exam.waaexamserver.domain.Book;
import edu.mum.cs.waa.exam.waaexamserver.domain.Category;
import edu.mum.cs.waa.exam.waaexamserver.service.BookService;
import edu.mum.cs.waa.exam.waaexamserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin(value = "http://localhost:9999", maxAge = 5000)
public class BookRestController {
    private BookService bookService;
    private CategoryService categoryService;
    @Autowired
    public BookRestController(BookService bookService, CategoryService categoryService){
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @PostMapping("/book")
    public @ResponseBody
    Iterable<Book> saveBook(@Valid @RequestBody Book book){

//        for (Category c: book.getCategoryList()
//             ) {
//            Category cc = categoryService.findById(c.getId()).get();
//            book.getCategoryList().add(cc);
//        }
        bookService.saveBook(book);
        return bookService.getAllBooks();
    }

    @GetMapping("/book")
    public @ResponseBody Iterable<Book> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/categories")
    public @ResponseBody Iterable<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

}

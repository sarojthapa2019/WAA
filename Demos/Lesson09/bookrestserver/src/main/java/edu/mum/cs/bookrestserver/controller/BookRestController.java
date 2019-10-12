package edu.mum.cs.bookrestserver.controller;

import edu.mum.cs.bookrestserver.domain.Book;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class BookRestController {

    @CrossOrigin(value = {"http://localhost:9000"}, maxAge = 5000)
    @PostMapping("/books")
    public Book addBook(@Valid @RequestBody Book book){
        System.out.println(book);
        //save to DB
        book.setId(Long.valueOf(LocalDateTime.now().getSecond()));
        return book;
    }
}

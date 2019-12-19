package edu.mum.cs.waa.exam.exampractice.service;

import edu.mum.cs.waa.exam.exampractice.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Iterable<Book> getAllBooks();
    Optional<Book> findById(Long id);
    Book saveBook(Book book);
    List<Book> findByCategoryId(Long id, Long s);
}

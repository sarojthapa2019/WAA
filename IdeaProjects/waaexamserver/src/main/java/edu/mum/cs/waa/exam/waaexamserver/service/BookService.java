package edu.mum.cs.waa.exam.waaexamserver.service;



import edu.mum.cs.waa.exam.waaexamserver.domain.Book;

import java.util.Optional;

public interface BookService {
    Iterable<Book> getAllBooks();
    Optional<Book> findById(Long id);
    Book saveBook(Book book);
}

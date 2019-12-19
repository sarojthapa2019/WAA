package edu.mum.cs.waa.exam.exampractice.service.serviceimpl;

import edu.mum.cs.waa.exam.exampractice.domain.Book;
import edu.mum.cs.waa.exam.exampractice.repository.BookRepository;
import edu.mum.cs.waa.exam.exampractice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findByCategoryId(Long id, Long ids) {
        return bookRepository.getAllByCategoryId(id, ids);
    }
}

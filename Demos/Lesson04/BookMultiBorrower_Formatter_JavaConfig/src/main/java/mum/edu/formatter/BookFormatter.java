package mum.edu.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import mum.edu.domain.Book;
import mum.edu.service.BookService;

@Component
public class BookFormatter implements Formatter<Book> {

	@Autowired
	private BookService bookService;
	
	@Override
	public String print(Book book, Locale locale) {
		return String.valueOf(book.getId());
	}

	@Override
	public Book parse(String text, Locale locale) throws ParseException {
		System.out.println(text + "------");
		return bookService.get(Long.parseLong(text));
	}

}

package edu.mum.cs.waa.exam.waaexamserver.repository;

import edu.mum.cs.waa.exam.waaexamserver.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}

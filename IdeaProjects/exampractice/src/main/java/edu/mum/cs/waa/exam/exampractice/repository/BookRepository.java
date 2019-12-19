package edu.mum.cs.waa.exam.exampractice.repository;

import edu.mum.cs.waa.exam.exampractice.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(value = "Select * from ybook where book_id in (select book_id from category  where category_id  =?1 or category_id = ?2) ", nativeQuery = true)
//    @Query("select b from mybook b inner join mybook.category where b.category =:id")
    List<Book> getAllByCategoryId(Long id, Long ids);
}

package edu.mum.cs.waa.exam.exampractice.repository;

import edu.mum.cs.waa.exam.exampractice.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}

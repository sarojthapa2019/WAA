package edu.mum.cs.waa.exam.waaexamserver.repository;

import edu.mum.cs.waa.exam.waaexamserver.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}

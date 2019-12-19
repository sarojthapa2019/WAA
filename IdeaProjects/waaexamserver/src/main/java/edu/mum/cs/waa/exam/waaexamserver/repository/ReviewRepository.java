package edu.mum.cs.waa.exam.waaexamserver.repository;

import edu.mum.cs.waa.exam.waaexamserver.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}

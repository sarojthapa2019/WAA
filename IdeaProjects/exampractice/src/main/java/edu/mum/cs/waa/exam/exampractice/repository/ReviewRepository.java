package edu.mum.cs.waa.exam.exampractice.repository;

import edu.mum.cs.waa.exam.exampractice.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}

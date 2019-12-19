package edu.mum.cs.waa.exam.exampractice.service.serviceimpl;

import edu.mum.cs.waa.exam.exampractice.domain.Review;
import edu.mum.cs.waa.exam.exampractice.repository.ReviewRepository;
import edu.mum.cs.waa.exam.exampractice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}

package edu.mum.cs.waa.exam.waaexamserver.service.serviceimpl;


import edu.mum.cs.waa.exam.waaexamserver.domain.Review;
import edu.mum.cs.waa.exam.waaexamserver.repository.ReviewRepository;
import edu.mum.cs.waa.exam.waaexamserver.service.ReviewService;
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

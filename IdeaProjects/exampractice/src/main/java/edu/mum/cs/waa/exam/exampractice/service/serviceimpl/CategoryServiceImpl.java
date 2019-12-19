package edu.mum.cs.waa.exam.exampractice.service.serviceimpl;

import edu.mum.cs.waa.exam.exampractice.domain.Category;
import edu.mum.cs.waa.exam.exampractice.repository.CategoryRepository;
import edu.mum.cs.waa.exam.exampractice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

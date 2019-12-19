package edu.mum.cs.waa.exam.waaexamserver.service.serviceimpl;


import edu.mum.cs.waa.exam.waaexamserver.domain.Category;
import edu.mum.cs.waa.exam.waaexamserver.repository.CategoryRepository;
import edu.mum.cs.waa.exam.waaexamserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }
}

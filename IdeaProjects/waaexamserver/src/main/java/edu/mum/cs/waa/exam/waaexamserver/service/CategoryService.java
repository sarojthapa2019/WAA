package edu.mum.cs.waa.exam.waaexamserver.service;


import edu.mum.cs.waa.exam.waaexamserver.domain.Category;

import java.util.Optional;

public interface CategoryService {
    Iterable<Category> getAllCategories();
    Optional<Category> findById(Integer id);
}

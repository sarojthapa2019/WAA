package edu.mum.cs.waa.exam.category_exam_rest_server.controller;

import edu.mum.cs.waa.exam.category_exam_rest_server.domain.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CategoryController {
    @CrossOrigin(value = {"http://127.0.0.1:8585", "http://localhost:8585"}, maxAge = 5000)
    @PostMapping(value="/categories")
    public @ResponseBody
    Category saveCategories(@Valid @RequestBody Category category){
        System.out.println("Saving category.......");
        return category;
    }
}

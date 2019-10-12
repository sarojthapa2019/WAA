package edu.mum.cs.bookrestserver.controller;

import edu.mum.cs.bookrestserver.domain.Category;
import edu.mum.cs.bookrestserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CateRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/v1/categories", produces = "application/xml")
    public @ResponseBody List<Category> getCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/v1/categories")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addCategory(@RequestBody Category category){
        System.out.println("----------------");
        categoryService.save(category);
    }
}

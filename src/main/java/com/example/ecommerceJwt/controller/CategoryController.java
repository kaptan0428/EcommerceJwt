package com.example.ecommerceJwt.controller;

import com.example.ecommerceJwt.model.Category;
import com.example.ecommerceJwt.service.CategoryService;
import jakarta.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add-category")
    public String addCategoryEndPoint(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PostMapping("/{id}")
    public String updateCategoryEndPoint(@PathVariable Integer id, @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryEndPoint(@PathVariable Integer id){
        return categoryService.deleteCategory(id);
    }

    @GetMapping("/")
    public List<Category> getAllCategoriesEndPoint(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/")
    public String getCategoryByAnyFieldEndPoint(@RequestBody Category category){
        return categoryService.getCategoryByAnyField(category);
    }
}

package com.example.ecommerceJwt.service;

import com.example.ecommerceJwt.model.Category;
import com.example.ecommerceJwt.model.Product;
import com.example.ecommerceJwt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public String addCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.getCategoryByCategoryName(category.getCategoryName());
        if(categoryOptional.isPresent()){
            return "Already a category with given name exist, try again !!!";
        }
        if(category.getCategoryName() == null){
            return "Provide the category name, try again !!!";
        }

        return categoryRepository.save(category).toString();
    }

    public String updateCategory(Integer id, Category category){
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isPresent()){
            Category myCategory = optionalCategory.get();
            if(category.getCategoryName() != null){
                return "can't update category name";
            }
            if(category.getCategoryDescription() == null){
                return "Invalid input";
            }
            myCategory.setCategoryDescription(category.getCategoryDescription());
            categoryRepository.save(myCategory);
            return myCategory.toString();
        }

        return "No category with given categoryId, try again !!!";
    }

    public String deleteCategory(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isPresent()){
            categoryRepository.delete(optionalCategory.get());
            return optionalCategory.get().toString();
        }
        return "No category exist with given id";
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public String getCategoryByAnyField(Category category){
        if(category.getCategoryId() != null){
            Optional<Category> optionalCategory = categoryRepository.findById(category.getCategoryId());
            if(optionalCategory.isPresent()){
                return optionalCategory.get().toString();
            }
            return "No category found";
        }
        if(category.getCategoryName() != null){
            Optional<Category> optionalCategory = categoryRepository.getCategoryByCategoryName(category.getCategoryName());
            if(optionalCategory.isPresent()){
                return optionalCategory.get().toString();
            }
            return "No category found";
        }
        return "Invalid input";
    }
}

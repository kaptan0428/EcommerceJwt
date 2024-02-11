package com.example.ecommerceJwt.repository;

import com.example.ecommerceJwt.model.Category;
import com.example.ecommerceJwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
    Optional<Category> getCategoryByCategoryName(String categoryName);
}

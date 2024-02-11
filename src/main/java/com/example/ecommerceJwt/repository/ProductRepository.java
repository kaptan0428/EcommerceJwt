package com.example.ecommerceJwt.repository;

import com.example.ecommerceJwt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.productName = :productName")
    Optional<Product> getProductByProductName(String productName);

}

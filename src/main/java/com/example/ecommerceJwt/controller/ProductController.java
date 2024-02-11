package com.example.ecommerceJwt.controller;

import com.example.ecommerceJwt.model.Product;
import com.example.ecommerceJwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add-product")
    public String addProductEndPoint(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PostMapping("/products/{id}")
    public String updateProductEndPoint(@PathVariable Integer id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("products/{id}")
    public String deleteProductEndPoint(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProductsEndPoint(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public String getProductByAnyFieldEndPoint(@RequestBody Product product){
        return productService.getProductByAnyField(product);
    }
}

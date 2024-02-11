package com.example.ecommerceJwt.service;

import com.example.ecommerceJwt.model.Product;
import com.example.ecommerceJwt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String createProduct(Product product){
        Optional<Product> productOptional = productRepository.getProductByProductName(product.getProductName());
        if(productOptional.isPresent()){
            return "Product with given productName already exist, try again !!!";
        }
        if(product.getProductName() == null){
            return "Please provide the product name, try again !!!";
        }
        productRepository.save(product);
        return product.toString();
    }

    public String updateProduct(Integer id, Product product){
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            Product myProduct = productOptional.get();

            if(product.getProductName() != null && !product.getProductName().equals((myProduct.getProductName()))){
                return "can't update product name, try again !!!";
            }

            if(product.getPrice() != null){
                myProduct.setPrice(product.getPrice());
            }
            if(product.getDescription() != null){
                myProduct.setDescription(product.getDescription());
            }
            if(product.getCategory() != null){
                myProduct.setCategory(product.getCategory());
            }

            productRepository.save(myProduct);
            return myProduct.toString();
        }
        return "No product matched with given productId, try again !!!";
    }

    public String deleteProduct(Integer id){

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            productRepository.delete(product);
            return "Product is deleted\n" + product.toString();
        }
        return "No Product found with given product id";
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public String getProductByAnyField(Product product){
        if((product.getProductId() != null && product.getProductName() != null) ||
                (product.getProductId() == null && product.getProductName() == null) ||
                (product.getPrice() != null) ||
                (product.getCategory() != null) ||
                (product.getDescription() != null))   {
            return "provide valid input";
        }


        if(product.getProductId() != null){
            Optional<Product> queryProduct = productRepository.findById(product.getProductId());
            if(queryProduct.isPresent()){
                return queryProduct.get().toString();
            }
        }
        if(product.getProductName() != null){
            Optional<Product> queryProduct = productRepository.getProductByProductName(product.getProductName());
            if(queryProduct.isPresent()){
                return queryProduct.get().toString();
            }
        }

        return "No Product found";
    }
}

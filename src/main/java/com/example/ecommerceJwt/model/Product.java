package com.example.ecommerceJwt.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ecommerce_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", unique = true, nullable = false)
    private String productName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;


}

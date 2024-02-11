package com.example.ecommerceJwt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ecommerce_category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name", unique = true, nullable = false)
    private String categoryName;

    @Column(name = "category_description")
    private String categoryDescription;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL )
//    private List<Product> products = new ArrayList<>();
}

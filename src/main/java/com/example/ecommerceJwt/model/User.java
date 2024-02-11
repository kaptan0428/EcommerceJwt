package com.example.ecommerceJwt.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity // maps java class to database table (from JPA)
@Data // it include getter() and setter()
@Table(name = "ecommerce_user")
public class User {

    @Id // makes ID primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password1", nullable = false)
    private String password1;

    @Column(name = "password2", nullable = false)
    private String password2;

    @Column(name = "email")
    private String email;
}

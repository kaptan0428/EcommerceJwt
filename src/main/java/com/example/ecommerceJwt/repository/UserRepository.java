package com.example.ecommerceJwt.repository;

import com.example.ecommerceJwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //  means this class serves as a repository or a Data Access Object(DAO) (from spring)
public interface UserRepository extends JpaRepository<User, Integer> {
    /* JpaRepository
              * provide a set of generic methods for CRUD operations and query execution.
              * It is a generic interface,
                  where you specify the entity type (<T>) and the type of the entity's primary key (<ID>).
                  For example, JpaRepository<User, Integer> specifies that
                  it's a repository for the User entity class with a primary key of type Integer.
    */

    @Query("SELECT u FROM User u WHERE u.userName = :userName") // JPQL
    Optional<User> getUserByUserName(String userName);
}

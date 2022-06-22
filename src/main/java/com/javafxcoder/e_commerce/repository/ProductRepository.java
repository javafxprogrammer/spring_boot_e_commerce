package com.javafxcoder.e_commerce.repository;

import com.javafxcoder.e_commerce.model.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query
    Optional<Product> findByName(String name);
    
}

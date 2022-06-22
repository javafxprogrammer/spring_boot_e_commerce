package com.javafxcoder.e_commerce.repository;

import com.javafxcoder.e_commerce.model.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query
    Optional<Customer> findByPhoneNumber(String phoneNumber);

    long deleteByPhoneNumber(String phone);
}

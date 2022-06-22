package com.javafxcoder.e_commerce.repository;

import com.javafxcoder.e_commerce.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
 
}

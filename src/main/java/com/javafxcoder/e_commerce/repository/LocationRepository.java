
package com.javafxcoder.e_commerce.repository;

import com.javafxcoder.e_commerce.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
}

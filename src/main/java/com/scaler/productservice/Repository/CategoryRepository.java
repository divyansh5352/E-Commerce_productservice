package com.scaler.productservice.Repository;

import com.scaler.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

// In JpaRepository we have to pass entity on which this repository will work and the datatype of its PK
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
    ArrayList<Category> findAll();

    Category save(Category category);
}

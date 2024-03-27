package com.scaler.productservice.Repository;

import com.scaler.productservice.Models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//@Repository
public interface ElasticsearchProductRepository extends JpaRepository<Product, Long> {
    //Optional<Product> findById(Long id );
    //Product save( Product product);
    //List<Product> findAll( );
    //void deleteById(Long id);

}

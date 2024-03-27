package com.scaler.productservice.Repository;

import com.scaler.productservice.Models.Product;
import com.scaler.productservice.Repository.Projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// In JpaRepository we have to pass entity on which this repository will work and the datatype of its PK
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByTitleContaining(String word);

    Optional<Product> findById(Long id);

    List<Product> findAll();
    //for paging change the above method to below method
    Page<Product> findAll(Pageable pageable);

    Product save(Product product);

    void deleteById(Long id);

    //if we have to write custom query then we can use the below annotation
    //This query is called HQL = Hibernate Query Language
    //HQL is in been SQL and OOP

    //Suppose we change the DB from SQL to MongoDB then we don't have to change the query
    //because this query is not a SQL query this is HQL query
    //  and hibernate will internally use same query to fetch data from MongoDB as well
    @Query("select p from Product p where p.Id = 2L")
    ArrayList<Product> something();

    //If we need only few attributes from the product class then we have to use something called projections
    //projection is an interface with the getter methods of attributes that we want
    @Query("select p.Id , p.title from Product p where p.Id = 1L")
    ArrayList<ProductWithIdAndTitle> something2 ();

    //Biggest problem with ORM is Performance
    //-> because we don't have exact control over the query , hibernate decide it itself
    //->HQL is the solution for this , because we can write queries ourselves

    // if we have to write SQL query then we can do that also :-
    // here we have to write the exact table name and colum name (exact same sql query)
    // if we change the DB then we have to change the query
    @Query(value = "Select * from tablename t where t.columnname is divyansh ",  nativeQuery = true)
    Product something3();


    // if we want to take parameter in query than we can do it as below:-
    // use colon : and annotate parameter with @Param
    @Query("select p from Product p where p.Id = :id")
    Product somwthing4(@Param("id") Long id);

}




package com.scaler.productservice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@JsonDeserialize
public class Category extends BaseModel{
    @JsonBackReference
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "category" , cascade = {CascadeType.REMOVE})
    // fetch:-
    // how to we want to fetch a product , LAZY or EAGER
    // if we do EAGER is will fetch the attributes of products also at the time of fetching category attributes
    // this will be done using a join query
    // if we don't need details of products with category attributes then we can mark it as LAZY
    // it will execute a query without a join which will save time.(1st DB query)
    // and when we will execute category.getProducts it will again execute a query (2nd DB query)

    // MappedBy:-
    // this will tell spring that this relationship is already mapped with category attribute of product class
    // cascade:-

    // CascadeType.REMOVE will remove all products if the category is removed
    private List<Product> products;
    private String name;

    public Category() {
    }
    //private  int description ;
}

/*
we can simply remove line 13 & 27 , but in this scenario
we want to get all products from category table as well,
so we are using this annotation @OneToMany in this class
 */
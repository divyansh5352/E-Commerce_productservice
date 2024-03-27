package com.scaler.productservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Getter
@Setter
@Entity
@JsonDeserialize
@Document(indexName = "Product")
public class Product extends BaseModel implements Serializable {
    private String title;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // persist means save and merge means update
    //@JsonIgnore
    @JsonManagedReference
    private Category category;
    @Column(length = 700)
    private String description;
    private String imageURL;

    public Product() {
    }
}

    // to add this we need to make new sql file to add this attribute to product table by alter command,
    // or we can do flyway versioned migration , it will automatically make a new sql file (V2__something)
    // and flyway will run that file before running the project
    //private int numberOfSale;

    // category attributes in product class
    // and list of products attribute in category class are both representing the same relationship
    // since spring don't know both are same relationship it will represent this relationship twice
    // once in product table and next in category table

    // so we will tell spring that this relation is already mapped by an attribute in another class
    // with the help to a suffix in cardinality annotation (mappedby = attributeName)
    // eg- see in category class

/*
we have category id as foreign key in our table,
now what if we want to delete a category
1> update product category to null
2> delete all products with that category
3> don't allow category to be deleted

to specify these constraints we can use cascade
1> CascadeType.ALL - if something happen to this category do the same thing to products
    eg- if someone try to delete a product category will also be deleted
        if someone try to update a product the category will also be updated
        if someone try to create a product , if there is a category in it , create that category

  here product class is saying if something happen to me do the same thing to category
  we can do the same logic in category class as well

  complete cascaded article = https://www.baeldung.com/jpa-cascade-types
 */


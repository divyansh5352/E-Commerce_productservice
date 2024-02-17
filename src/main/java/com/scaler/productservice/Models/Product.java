package com.scaler.productservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private Long id;
    private String title;
    private double price;
    private  Category category;
    private String  description;
    private String imageURL;
}

package com.scaler.productservice.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.scaler.productservice.Models.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addProductDTO {
    private String title;
    private Double price;
    private String categoryName;
    private String description;
    private String imageURL;
}

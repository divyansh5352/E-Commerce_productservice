package com.scaler.productservice.Servies;

import com.scaler.productservice.DTO.addProductDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Product;

import java.util.ArrayList;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    ArrayList<Product> getAllProducts();
    Product replaceProduct(Long id , Product product) throws ProductNotFoundException;
    Product updateProduct( Long id , Product product) throws ProductNotFoundException;
    Product addNewProduct( addProductDTO product);
    boolean deleteProduct( Long id ) throws ProductNotFoundException;

}

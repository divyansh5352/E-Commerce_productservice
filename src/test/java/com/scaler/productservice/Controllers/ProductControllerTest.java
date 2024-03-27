//package com.scaler.productservice.Controllers;
//
//import com.scaler.productservice.Models.Product;
//import com.scaler.productservice.Servies.ProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class ProductControllerTest {
//
//    //Junit is defaults framework to write test cases in java
//    //Mockito is the defaults standard for mocking things in java
//
//    //Arrange
////    @Autowired
////    private ProductController productController;
////
////    @MockBean
////    private ProductService productService;
////    @Test
////    void testProductsSameAsService(){
////
////        ArrayList<Product> products = new ArrayList<>();
////        Product p1 = new Product();
////        p1.setTitle("iphone15");
////        products.add(p1);
////
////        Product p2 = new Product();
////        p2.setTitle("iphone15");
////        products.add(p2);
////
////        Product p3 = new Product();
////        p3.setTitle("iphone15");
////        products.add(p3);
////
////        when(
////                productService.getAllProducts()
////        ).thenReturn(
////                products
////        );
//
//        //Act
//        //ResponseEntity<ArrayList<Product>> response = productController.getAllProduct();
//        //productController will internally call productService.get all product.
//        //but we have mocked productService line31,
//        //so it will return new arraylist.
//
//        //Assert
////        ArrayList<Product>productInResponse = response.getBody();
////        assertEquals(products.size() , productInResponse.size() );
//
//
//    //}
//
//}
package com.scaler.productservice.Controllers;

import com.scaler.productservice.Commons.AuthenticationCommons;
import com.scaler.productservice.DTO.Role;
import com.scaler.productservice.DTO.addProductDTO;
import com.scaler.productservice.DTO.userDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.Models.Product;
import com.scaler.productservice.Servies.FakeStoreProductService;
import com.scaler.productservice.Servies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController  {

    private ProductService productService;
    private RestTemplate restTemplate;
    private AuthenticationCommons authenticationCommons;


    @Autowired
    public ProductController(
            //@Qualifier("SelfProductService")
             ProductService productService,RestTemplate restTemplate, AuthenticationCommons authenticationCommons) {
        //@Qualifier will tell which bean ProductService need to be autowired in this class
        this.productService = productService;
        this.restTemplate = restTemplate;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Product>> getAllProduct(/*@RequestHeader("token") String token*/){

//        userDTO userDTO = authenticationCommons.validateToken(token);
//        if(userDTO == null ){
//            return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        boolean isAdmin =false;
//        for (Role role : userDTO.getRoles()){
//            if( role.getName().equals("ADMIN")){
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if ( isAdmin == false){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }

        //for paging change method to
        //getAllProduct(@RequestParam("pageNumber")int pageNumber,
        //              @RequestParam("pageSize")  int pageSize,
        //              @RequestParam("sortBy")    String sortBy,
        //              @RequestParam("sortOrder") String sortOrder);
        //to call this method call:-
        //localhost:8080/products?pageSize=3&pageNumber=0
        return new ResponseEntity<>(productService.getAllProducts() , HttpStatus.OK);

    }
    @GetMapping("/{ID}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("ID") Long id ) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getSingleProduct(id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody addProductDTO productDTO ){
        return new ResponseEntity<>(productService.addNewProduct(productDTO),HttpStatus.OK);
    }
    @PatchMapping("/{ID}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id ) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.updateProduct(id , product),HttpStatus.OK);
    }

    @PutMapping("/{ID}")
    public ResponseEntity<Product> replaceProduct(@RequestBody Product product, @PathVariable("id") Long id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.replaceProduct(id,product),HttpStatus.OK);
    }
    @DeleteMapping("/{ID}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") Long id ) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }


}

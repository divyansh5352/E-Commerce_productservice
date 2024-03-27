package com.scaler.productservice.Controllers;

import com.scaler.productservice.Exceptions.CategoryNotFoundException;
import com.scaler.productservice.Models.Category;
import com.scaler.productservice.Servies.CategoryService;
import com.scaler.productservice.Servies.SelfcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ArrayList<Category>> getAllCategory(){
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Category> getSingleCategory(@PathVariable("name")String name) throws CategoryNotFoundException {
            return new ResponseEntity<>(categoryService.getSingleCategory(name) , HttpStatus.OK);
    }
}

package com.scaler.productservice.Servies;

import com.scaler.productservice.Exceptions.CategoryNotFoundException;
import com.scaler.productservice.Models.Category;
import com.scaler.productservice.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SelfcategoryService implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public ArrayList<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getSingleCategory(String name) throws CategoryNotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findByName(name);

        if ( categoryOptional.isEmpty()){
            throw new CategoryNotFoundException("Category with name:"+name+" doesn't exists");
        }
        else {
            return categoryOptional.get();
        }
    }

    @Override
    public Category addCategory(String name) {
        Category category = new Category();
        category.setName(name);

        return categoryRepository.save(category);
    }
}

package com.scaler.productservice.Servies;

import com.scaler.productservice.Exceptions.CategoryNotFoundException;
import com.scaler.productservice.Models.Category;

import java.util.ArrayList;

public interface CategoryService {
    ArrayList<Category> getAllCategory();

    Category getSingleCategory(String name) throws CategoryNotFoundException;

    Category addCategory(String name);
}

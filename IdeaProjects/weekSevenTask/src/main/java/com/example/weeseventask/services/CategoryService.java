package com.example.weeseventask.services;

import com.example.weeseventask.model.Category;

import java.util.List;


public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
}

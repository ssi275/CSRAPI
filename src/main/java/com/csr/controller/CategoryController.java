package com.csr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csr.entity.Category;
import com.csr.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/category", method = {RequestMethod.GET})
    public List<Category> getCategories() {
        return categoryService.fetchCateoryList();
    }
    
    @RequestMapping(value = "/category", method = {RequestMethod.POST})
    public boolean getCategories(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

}
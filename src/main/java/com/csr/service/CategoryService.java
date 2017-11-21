package com.csr.service;

import java.util.List;

import com.csr.entity.Category;

public interface CategoryService {

    public List<Category> fetchCateoryList();
    public boolean saveCategory(Category category);
}
package com.csr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csr.dao.ReadDao;
import com.csr.dao.SaveDao;
import com.csr.entity.Category;
import com.csr.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ReadDao readDao;

    @Autowired
    SaveDao saveDao;

    @Override
    public List<Category> fetchCateoryList() {
        List<Category> categoryList = readDao.getCategoryList();
        return categoryList;
    }

    @Override
    public boolean saveCategory(
            Category category) {
        if (null != category.getName()) {
            saveDao.saveCategory(category);
            return true;
        } else
            return false;

    }

}
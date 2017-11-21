package com.csr.mongoRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.csr.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String>{
    
    public Category findByName(String name);
    
}
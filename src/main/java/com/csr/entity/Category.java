package com.csr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CATEGORY")
public class Category {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(
            String name) {
        this.name = name;
    }

}
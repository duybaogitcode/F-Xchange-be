package com.example.fxchangebe.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "categories")
public class Category {
    @Id
    private int id;

    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}

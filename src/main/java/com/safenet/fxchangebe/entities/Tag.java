package com.safenet.fxchangebe.entities;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "tags")
public class Tag {
    @Id
    private int id;

    private String name;

    private List<String> value;

    public Tag() {
    }

    public Tag(String name, List<String> value) {
        this.name = name;
        this.value = value;
    }
}

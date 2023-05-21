package com.example.fxchangebe.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Author {

    @Field("user_id")
    private ObjectId userId;

    private String fullname;

    public Author() {
    }

    public Author(ObjectId user_id, String fullname) {
        this.userId = user_id;
        this.fullname = fullname;
    }
}

package com.safenet.fxchangebe.entities;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "comments")
public class Comment {
    @Id
    private ObjectId id;

    private String content;

    private Author author;

    @Field("stuff_id")
    private ObjectId stuffId;

    @CreatedDate
    @Field("create_at")
    private Date createAt;

    @LastModifiedDate
    @Field("update_at")
    private Date updateAt;

    public Comment() {
    }

    public Comment(String content, Author author, ObjectId stuffId, Date createAt, Date updateAt) {
        this.content = content;
        this.author = author;
        this.stuffId = stuffId;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}

package com.safenet.fxchangebe.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "comments")
public class Comment {
    @Id
    private ObjectId id;

    private String content;

    private User author;

    @Field("stuff_id")
    private ObjectId stuffId;

    @CreatedDate
    @Field("create_at")
    private Date createAt;

    @LastModifiedDate
    @Field("update_at")
    private Date updateAt;

}

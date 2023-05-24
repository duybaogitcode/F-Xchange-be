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
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Document(collection = "stuff")
public class Stuff {

    @Id
    private ObjectId id;

    private String title;

    private String content;

    private List<String> images;

    private User author;

    private int condition;

    private String category;

    private String type;

    private List<Map<String,String>> tags;

    private Status status;

    @Field("custom_field")
    private Map<String, Object> customField;

    @CreatedDate
    @Field("create_at")
    private Date createAt;

    @LastModifiedDate
    @Field("update_at")
    private Date updateAt;

}

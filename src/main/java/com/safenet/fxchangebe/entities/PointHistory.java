package com.safenet.fxchangebe.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "point_history")
public class PointHistory {
    @Id
    private ObjectId id;

    private String content;

    private int change;

    @Field("user_id")
    private ObjectId userId;

    @CreatedDate
    private Date time;

}

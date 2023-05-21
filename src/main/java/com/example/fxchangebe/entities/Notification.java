package com.example.fxchangebe.entities;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private ObjectId id;

    private String content;

    private NotiType type;

    @Field("user_id")
    private ObjectId userId;

    @Field("target_id")
    private ObjectId targetId;

    private String url;

    @CreatedDate
    private Date time;

    public Notification() {
    }

    public Notification(String content, NotiType type, ObjectId userId, ObjectId targetId, String url, Date time) {
        this.content = content;
        this.type = type;
        this.userId = userId;
        this.targetId = targetId;
        this.url = url;
        this.time = time;
    }
}

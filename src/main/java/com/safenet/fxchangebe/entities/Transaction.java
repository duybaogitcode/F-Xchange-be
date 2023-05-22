package com.safenet.fxchangebe.entities;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "transactions")
public class Transaction {
    @Id
    private ObjectId id;

    @Field("customer_id")
    private ObjectId customerId;

    @Field("stuff_id")
    private ObjectId stuffId;

    @Field("custom_field")
    private Map<String, Object> customField;

    private Map<String, String> status;

    @CreatedDate
    @Field("create_at")
    private Date createAt;

    @LastModifiedDate
    @Field("update_at")
    private Date updateAt;

    public Transaction() {
    }

    public Transaction(ObjectId customerId, ObjectId stuffId, Map<String, Object> customField, Map<String, String> status, Date createAt, Date updateAt) {
        this.customerId = customerId;
        this.stuffId = stuffId;
        this.customField = customField;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}

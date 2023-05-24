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
import java.util.Map;

@Data
@NoArgsConstructor
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

    private Map<Status, String> status;

    @CreatedDate
    @Field("create_at")
    private Date createAt;

    @LastModifiedDate
    @Field("update_at")
    private Date updateAt;

}

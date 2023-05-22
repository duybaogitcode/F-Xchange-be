package com.safenet.fxchangebe.entities;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "users")
public class User {
    @Id
    private ObjectId id;

    private Information informations;

    @Field("google_id")
    @Indexed(unique = true)
    private String googleId;

    @DBRef
    private Role role;

    private int point;

    @Field("invitation_code")
    private String invitationCode;

    private Status status;

    @CreatedDate
    @Field("create_at")
    private Date createAt;

    @LastModifiedDate
    @Field("update_at")
    private Date updateAt;

    private List<ObjectId> stuff;

    @Field("attendance_dates")
    private List<Date> attendanceDates;

    private List<ObjectId> transactions;

    public User() {
    }

    public User(Information informations, String googleId, Role role, int point, String invitationCode, Status status, Date createAt, Date updateAt, List<ObjectId> stuff, List<Date> attendanceDates, List<ObjectId> transactions) {
        this.informations = informations;
        this.googleId = googleId;
        this.role = role;
        this.point = point;
        this.invitationCode = invitationCode;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.stuff = stuff;
        this.attendanceDates = attendanceDates;
        this.transactions = transactions;
    }
}
